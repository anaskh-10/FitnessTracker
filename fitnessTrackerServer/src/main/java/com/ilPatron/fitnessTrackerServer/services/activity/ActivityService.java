package com.ilPatron.fitnessTrackerServer.services.activity;

import com.ilPatron.fitnessTrackerServer.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
     ActivityDTO postActivity(ActivityDTO dto);
     List<ActivityDTO> getActivities();
     void deleteActivity(Long id);
}
