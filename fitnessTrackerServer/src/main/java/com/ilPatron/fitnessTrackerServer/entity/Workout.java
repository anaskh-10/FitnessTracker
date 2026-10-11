package com.ilPatron.fitnessTrackerServer.entity;

import com.ilPatron.fitnessTrackerServer.dto.WorkoutDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false)
    private int caloriesBurned;

    @ManyToMany
    private List<Goal> goals=new ArrayList<>();
    @ManyToOne
    private User user;


    public Workout() {}

    public Workout(Long id, String type, Date date, int duration, int caloriesBurned, List<Goal> goals) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.duration = duration;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WorkoutDTO getWorkoutDto() {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(id);
        workoutDTO.setType(type);
        workoutDTO.setDate(date);
        workoutDTO.setDuration(duration);
        workoutDTO.setCaloriesBurned(caloriesBurned);
        return workoutDTO;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", duration=" + duration +
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
