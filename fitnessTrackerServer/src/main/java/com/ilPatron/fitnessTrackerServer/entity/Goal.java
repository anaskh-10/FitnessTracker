package com.ilPatron.fitnessTrackerServer.entity;

import com.ilPatron.fitnessTrackerServer.dto.GoalDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private boolean achieved;
    @OneToMany()
    private List<Activity> activities=new ArrayList<>();
    @OneToMany()
    private List<Workout> workouts=new ArrayList<>();
    @ManyToOne
    private User user;
    public Goal() {
    }

    public Goal(Long id, String description, Date startDate, Date endDate, boolean achieved, List<Activity> activities, List<Workout> workouts) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.achieved = achieved;
        this.activities = activities;
        this.workouts = workouts;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
    public GoalDTO getGoalDTO(){
        GoalDTO goalDTO=new GoalDTO();
        goalDTO.setId(id);
        goalDTO.setDescription(description);
        goalDTO.setStartDate(startDate);
        goalDTO.setEndDate(endDate);
        goalDTO.setAchieved(achieved);
        return goalDTO;
    }
    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", achieved=" + achieved +
                '}';
    }
}
