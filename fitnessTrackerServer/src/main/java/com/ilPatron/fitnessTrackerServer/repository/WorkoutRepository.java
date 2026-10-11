package com.ilPatron.fitnessTrackerServer.repository;

import com.ilPatron.fitnessTrackerServer.entity.Activity;
import com.ilPatron.fitnessTrackerServer.entity.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query("select sum(duration) from Workout")
    Integer getTotalDuration();
    @Query("select sum(caloriesBurned) from Workout")
    Integer getTotalCaloriesBurned();
    @Query("select w from Workout w order by w.date DESC")
    List<Workout>findLast7Workouts(Pageable pageable);

}
