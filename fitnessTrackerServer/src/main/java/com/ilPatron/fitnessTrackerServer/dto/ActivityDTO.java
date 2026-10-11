package com.ilPatron.fitnessTrackerServer.dto;

import java.util.Date;

public class ActivityDTO {

    private Long id;
    private Date date;
    private int steps;
    private double distance;
    private int caloriesBurned;


    public ActivityDTO(Long id, Date date, int steps, double distance, int caloriesBurned) {
        this.id = id;
        this.date = date;
        this.steps = steps;
        this.distance = distance;
        this.caloriesBurned = caloriesBurned;
    }

    public ActivityDTO() {

    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "id=" + id +
                ", date=" + date +
                ", steps=" + steps +
                ", distance=" + distance +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
