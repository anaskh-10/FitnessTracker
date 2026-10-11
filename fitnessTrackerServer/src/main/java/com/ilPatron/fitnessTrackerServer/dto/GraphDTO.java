package com.ilPatron.fitnessTrackerServer.dto;

import java.util.List;

public class GraphDTO {
    private List<WorkoutDTO> workouts;

    private List<ActivityDTO> activity;

    public GraphDTO() {
    }

    public GraphDTO(List<WorkoutDTO> workouts, List<ActivityDTO> activity) {
        this.workouts = workouts;
        this.activity = activity;
    }

    public List<WorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ActivityDTO> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityDTO> activity) {
        this.activity = activity;
    }
}
