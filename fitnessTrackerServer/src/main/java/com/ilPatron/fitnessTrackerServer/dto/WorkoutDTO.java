package com.ilPatron.fitnessTrackerServer.dto;

import java.util.Date;

public class WorkoutDTO {
    private Long id;

    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;

    public WorkoutDTO() {
    }

    public WorkoutDTO(Long id, String type, Date date, int duration, int caloriesBurned) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "WorkoutDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
