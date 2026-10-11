package com.ilPatron.fitnessTrackerServer.services.workout;

import com.ilPatron.fitnessTrackerServer.dto.WorkoutDTO;
import com.ilPatron.fitnessTrackerServer.entity.Workout;
import com.ilPatron.fitnessTrackerServer.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{
    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public WorkoutDTO postWorkout(WorkoutDTO dto){
        Workout workout=new Workout();
        workout.setDate(dto.getDate());
        workout.setType(dto.getType());
        workout.setDuration(dto.getDuration());
        workout.setCaloriesBurned(dto.getCaloriesBurned());
        return workoutRepository.save(workout).getWorkoutDto();
    }
    public List<WorkoutDTO> getWorkout(){
        List<Workout> workouts=workoutRepository.findAll();
        return workouts.stream().map(Workout::getWorkoutDto).toList();
    }
    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
