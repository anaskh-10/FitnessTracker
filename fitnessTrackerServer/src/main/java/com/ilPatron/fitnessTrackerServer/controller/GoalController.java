package com.ilPatron.fitnessTrackerServer.controller;

import com.ilPatron.fitnessTrackerServer.dto.GoalDTO;
import com.ilPatron.fitnessTrackerServer.services.goal.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }
    @PostMapping("/goal")
    public ResponseEntity<?> postGoal(@RequestBody GoalDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(goalService.postGoal(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/goals")
    public ResponseEntity<?>getGoals(){
        try{
            return ResponseEntity.ok(goalService.getGoals());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong .");
        }
    }
    @DeleteMapping("/goal/{id}")
    public ResponseEntity<?> deleteGoal(@PathVariable Long id) {
        try {
            goalService.deleteGoal(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
        }
    }
    @GetMapping("/goal/status/{id}")
    public ResponseEntity<?> upDateStatus(@PathVariable Long id){
        try {
            return ResponseEntity.ok(goalService.upDateStatus(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
