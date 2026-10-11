package com.ilPatron.fitnessTrackerServer.controller;

import com.ilPatron.fitnessTrackerServer.dto.GraphDTO;
import com.ilPatron.fitnessTrackerServer.services.stats.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    public ResponseEntity<?>getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }
    @GetMapping("/graphs")
    public ResponseEntity<?>getGraphStats(){
        GraphDTO graphDTO=statsService.getGraphStats();
        if(graphDTO!=null){
            return ResponseEntity.ok(graphDTO);
        }else {
            return ResponseEntity.status(484).body(null);
        }
    }
}
