package com.ilPatron.fitnessTrackerServer.dto;

public class StatsDTO {

    private long achievedGoals;

    private long notAchievedGoals;

    private int steps;

    private Double distance;

    private int totalCaloriesBurned;

    private int duration;


    public StatsDTO() {
    }

    public StatsDTO(long achievedGoals, long notAchievedGoals, int steps, Double distance, int totalCaloriesBurned, int duration) {
        this.achievedGoals = achievedGoals;
        this.notAchievedGoals = notAchievedGoals;
        this.steps = steps;
        this.distance = distance;
        this.totalCaloriesBurned = totalCaloriesBurned;
        this.duration = duration;
    }

    public long getAchievedGoals() {
        return achievedGoals;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public int getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(int totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public void setAchievedGoals(long achievedGoals) {
        this.achievedGoals = achievedGoals;
    }

    public long getNotAchievedGoals() {
        return notAchievedGoals;
    }

    public void setNotAchievedGoals(long notAchievedGoals) {
        this.notAchievedGoals = notAchievedGoals;
    }

    @Override
    public String toString() {
        return "StatsDTO{" +
                "achievedGoals=" + achievedGoals +
                ", notAchievedGoals=" + notAchievedGoals +
                '}';
    }
}
