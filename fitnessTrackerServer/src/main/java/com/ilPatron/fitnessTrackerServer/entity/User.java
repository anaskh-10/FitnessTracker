package com.ilPatron.fitnessTrackerServer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 50, nullable = false)
    private String password;
    @OneToMany
    private List<Activity> activities=new ArrayList<>();
    @OneToMany
    private List<Workout> workouts=new ArrayList<>();
    @OneToMany
    private List<Goal> goals=new ArrayList<>();
    public User() {}

    public User(Long id, String username, String password, List<Activity> activities, List<Workout> workouts, List<Goal> goals) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.activities = activities;
        this.workouts = workouts;
        this.goals = goals;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}