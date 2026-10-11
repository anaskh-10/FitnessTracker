package com.ilPatron.fitnessTrackerServer.repository;

import com.ilPatron.fitnessTrackerServer.entity.Activity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("Select sum(steps) from Activity")
    Integer getTotalSteps();
    @Query("Select sum(distance) from Activity")
    Double getTotalDistance();
    @Query("select sum(caloriesBurned) from Activity")
    Integer getTotalActivityCalories();
    @Query("select a from Activity a order by a.date DESC")
    List<Activity>findLast7Activities(Pageable pageable);
}
