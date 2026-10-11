package com.ilPatron.fitnessTrackerServer.controller;

import com.ilPatron.fitnessTrackerServer.dto.ActivityDTO;
import com.ilPatron.fitnessTrackerServer.dto.UserLoginDTO;
import com.ilPatron.fitnessTrackerServer.services.activity.ActivityService;
import com.ilPatron.fitnessTrackerServer.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO dto){

        ActivityDTO createActivity= activityService.postActivity(dto);
        if (createActivity!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. ");
        }
    }


    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(HttpSession session){
        try{
            return ResponseEntity.ok(activityService.getActivities());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. ");
        }
    }
    @DeleteMapping("/activity/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id){
        try {
            activityService.deleteActivity(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
        }
    }
}
