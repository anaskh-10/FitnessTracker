package com.ilPatron.fitnessTrackerServer.controller;

import com.ilPatron.fitnessTrackerServer.dto.WorkoutDTO;
import com.ilPatron.fitnessTrackerServer.services.workout.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WorkoutController {
    private final WorkoutService workoutService;
    public WorkoutController(WorkoutService workoutService){
        this.workoutService=workoutService;
    }
    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDTO workoutDTO){
        WorkoutDTO createWorkout = workoutService.postWorkout(workoutDTO);
        if(createWorkout!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createWorkout);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong. ");
        }
    }
    @GetMapping("/workouts")
    public ResponseEntity<?> getWorkouts(){
        try{
            return ResponseEntity.ok(workoutService.getWorkout());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong. ");
        }
    }
    @DeleteMapping("/workout/{id}")
    public ResponseEntity<?> deleteWorkout(@PathVariable Long id) {
        try {
            workoutService.deleteWorkout(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
        }
    }


}
