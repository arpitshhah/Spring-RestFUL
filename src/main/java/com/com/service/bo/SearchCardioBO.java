package com.com.service.bo;


import com.pojo.Exercise;
import com.service.jdbc.SearchCardioJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arpit on 4/8/2018.
 */

@Service("searchCardioBO")
public class SearchCardioBO {

    @Autowired
    SearchCardioJDBC searchCardioJDBC;

    public List<Exercise> searchChallenges(String levels, String input){
        return getSearchCardioJDBC().searchChallenges(levels,input);
    }

    public SearchCardioJDBC getSearchCardioJDBC() {
        return searchCardioJDBC;
    }

    public void setSearchCardioJDBC(SearchCardioJDBC searchCardioJDBC) {
        this.searchCardioJDBC = searchCardioJDBC;
    }
}
