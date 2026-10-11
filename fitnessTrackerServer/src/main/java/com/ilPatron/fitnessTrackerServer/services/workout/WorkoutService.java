package com.ilPatron.fitnessTrackerServer.services.workout;

import com.ilPatron.fitnessTrackerServer.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {
    WorkoutDTO postWorkout(WorkoutDTO dto);
    List<WorkoutDTO> getWorkout();
    void deleteWorkout(Long id);
}
