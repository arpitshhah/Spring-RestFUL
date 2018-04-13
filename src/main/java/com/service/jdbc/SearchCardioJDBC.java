package com.service.jdbc;

import com.pojo.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Arpit on 4/8/2018.
 */
public class SearchCardioJDBC {

    private DataSource dataSource;
    private  JdbcTemplate jdbcTemplateObject;
    private static boolean populateData=true;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public  void populate() {
        jdbcTemplateObject.execute("drop TABLE CARDIO_CHALLENGES");
        jdbcTemplateObject.execute("CREATE TABLE CARDIO_CHALLENGES(id number(19) NOT NULL PRIMARY KEY, name VARCHAR2(1000) NOT NULL, type VARCHAR2(1000) NOT NULL " +
                ",calories_burn NUMBER(19) NOT NULL,distance_reps NUMBER(19) NOT NULL, LEVELs CHAR(1) NOT NULL,keyword VARCHAR2(4000) NOT NULL)");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1000,'Run','CARDIO',200,1.5,'B','RUNCARDIO200')");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1001,'Run','CARDIO',400,3,'I','RUNCARDIO400')");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1002,'Run','CARDIO',800,5,'A','RUNCARDIO800')");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1003,'PushUps','CARDIO',100,30,'B','PUSHUPCARDIO10030')");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1004,'PushUps','CARDIO',200,60,'I','PUSHUPCARDIO20060')");
        jdbcTemplateObject.update("INSERT INTO cardio_challenges VALUES(1005,'PushUps','CARDIO',300,100,'A','PUSHUPCARDIO300100')");
        jdbcTemplateObject.execute("COMMIT");
        populateData=false;
    }
    public List<Exercise> searchChallenges(String levels, String input){
        if(populateData)
            populate();
        String SQL = "select * from CARDIO_CHALLENGES where levels like '%"+levels+"%' and upper(keyword) like '%"+input.toUpperCase()+"%' ";
        System.out.print(SQL);
        List<Exercise> exercises = jdbcTemplateObject.query(SQL, new RowMapper<Exercise>()
        {
            public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
                Exercise exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setName(rs.getString("name"));
                exercise.setCaloriesBurn(rs.getInt("calories_burn"));
                exercise.setDistanceReps(rs.getInt("distance_reps"));
                exercise.setType(rs.getString("type"));
                exercise.setLevels(rs.getString("LEVELs").charAt(0));
                return exercise;
            }
        });
        return exercises;
    }
}
