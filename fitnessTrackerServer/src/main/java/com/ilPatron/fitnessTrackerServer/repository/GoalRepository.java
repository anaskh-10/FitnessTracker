package com.ilPatron.fitnessTrackerServer.repository;

import com.ilPatron.fitnessTrackerServer.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {
    @Query("Select count(g) from Goal g where g.achieved=true ")
    Long countAchievedGoals();
    @Query("Select count(g) from Goal g where g.achieved=false")
    Long countNotAchievedGoals();
}
