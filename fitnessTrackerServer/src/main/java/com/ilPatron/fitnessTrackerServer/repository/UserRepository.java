package com.ilPatron.fitnessTrackerServer.repository;

import com.ilPatron.fitnessTrackerServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id = id")
    Optional<User> findUserById( Long id);
}