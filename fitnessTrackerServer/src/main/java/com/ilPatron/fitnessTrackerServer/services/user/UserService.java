package com.ilPatron.fitnessTrackerServer.services.user;

import com.ilPatron.fitnessTrackerServer.entity.User;

import java.util.Optional;

public interface UserService {
    boolean register(String username, String password);
    boolean authenticate(String username, String password);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserById(Long id);

}
