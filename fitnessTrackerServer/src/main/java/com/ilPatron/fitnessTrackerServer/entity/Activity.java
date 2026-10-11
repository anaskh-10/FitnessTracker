package com.ilPatron.fitnessTrackerServer.entity;

import com.ilPatron.fitnessTrackerServer.dto.ActivityDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private int steps;
    @Column(nullable = false)
    private double distance;
    @Column(nullable = false)
    private int caloriesBurned;

    @ManyToMany
    private List<Goal> goals=new ArrayList<>();
    @ManyToOne
    private User user;

    public Activity() {}


    public Activity(Long id, Date date, int steps, double distance, int caloriesBurned,List<Goal> goals) {
        this.id = id;
        this.date = date;
        this.steps = steps;
        this.distance = distance;
        this.caloriesBurned = caloriesBurned;
        this.goals=goals;
    }

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

    public ActivityDTO getActivityDTO() {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(id);
        activityDTO.setDate(date);
        activityDTO.setDistance(distance);
        activityDTO.setSteps(steps);
        activityDTO.setCaloriesBurned(caloriesBurned);

        return activityDTO;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", date=" + date +
                ", steps=" + steps +
                ", distance=" + distance +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
}
