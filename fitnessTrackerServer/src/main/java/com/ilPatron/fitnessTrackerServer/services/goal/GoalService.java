package com.ilPatron.fitnessTrackerServer.services.goal;

import com.ilPatron.fitnessTrackerServer.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    GoalDTO postGoal(GoalDTO dto);
    List<GoalDTO> getGoals();

    GoalDTO upDateStatus(Long id);
    void deleteGoal(Long id);
}
