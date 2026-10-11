package com.ilPatron.fitnessTrackerServer.services.stats;

import com.ilPatron.fitnessTrackerServer.dto.GraphDTO;
import com.ilPatron.fitnessTrackerServer.dto.StatsDTO;
import com.ilPatron.fitnessTrackerServer.entity.Activity;
import com.ilPatron.fitnessTrackerServer.entity.Workout;
import com.ilPatron.fitnessTrackerServer.repository.ActivityRepository;
import com.ilPatron.fitnessTrackerServer.repository.GoalRepository;
import com.ilPatron.fitnessTrackerServer.repository.WorkoutRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImpl implements StatsService {

    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;

    public StatsServiceImpl(GoalRepository goalRepository, ActivityRepository activityRepository, WorkoutRepository workoutRepository) {
        this.goalRepository = goalRepository;
        this.activityRepository = activityRepository;
        this.workoutRepository = workoutRepository;
    }

    public StatsDTO getStats() {
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0)
                + (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0);

        StatsDTO dto = new StatsDTO();

        dto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0);

        dto.setSteps(totalSteps != null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance : 0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);

        dto.setDuration(totalDuration != null ? totalDuration : 0);

        return dto;
    }

    public GraphDTO getGraphStats() {
        Pageable pageable = PageRequest.of(0, 7);

        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream()
                .map(Workout::getWorkoutDto)
                .collect(Collectors.toList()));
        graphDTO.setActivity(activities.stream()
                .map(Activity::getActivityDTO)
                .collect(Collectors.toList()));

        return graphDTO;
    }
}
