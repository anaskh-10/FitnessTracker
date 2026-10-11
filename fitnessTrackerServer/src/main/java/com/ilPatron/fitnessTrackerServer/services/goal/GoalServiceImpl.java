package com.ilPatron.fitnessTrackerServer.services.goal;

import com.ilPatron.fitnessTrackerServer.dto.GoalDTO;
import com.ilPatron.fitnessTrackerServer.entity.Goal;
import com.ilPatron.fitnessTrackerServer.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService{
    private final GoalRepository goalRepository ;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalDTO postGoal(GoalDTO dto){
        Goal goal =new Goal();
        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(false);
        return goalRepository.save(goal).getGoalDTO();
    }
    public List<GoalDTO> getGoals(){
        List<Goal> goals= goalRepository.findAll();
        return goals.stream().map(Goal::getGoalDTO).collect(Collectors.toList());
    }
    public GoalDTO upDateStatus(Long id){
        Optional<Goal> optionalGoal=goalRepository.findById(id);
        if(optionalGoal.isPresent()){
            Goal exitingGoal=optionalGoal.get();
            exitingGoal.setAchieved(true);
            return goalRepository.save(exitingGoal).getGoalDTO();
        }
        throw new EntityNotFoundException("Goal Not Found.");
    }
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}
