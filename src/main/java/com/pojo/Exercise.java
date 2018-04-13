package com.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arpit on 4/8/2018.
 */
public class Exercise {

    public static final String BEGINNER ="B";
    public static final String INTERMEDIATE="I";
    public static final String ADVANCE="A";

    private long id;

    private String name;

    private String type;

    private int caloriesBurn;

    private int distanceReps;

    private char levels;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCaloriesBurn() {
        return caloriesBurn;
    }

    public void setCaloriesBurn(int caloriesBurn) {
        this.caloriesBurn = caloriesBurn;
    }

    public int getDistanceReps() {
        return distanceReps;
    }

    public void setDistanceReps(int distanceReps) {
        this.distanceReps = distanceReps;
    }

    public char getLevels() {
        return levels;
    }

    public void setLevels(char levels) {
        this.levels = levels;
    }
}
