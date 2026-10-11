package com.ilPatron.fitnessTrackerServer.services.user;

import com.ilPatron.fitnessTrackerServer.entity.User;
import com.ilPatron.fitnessTrackerServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean register(String username, String password) {
        // Check if the username already exists
        if (userRepository.findByUsername(username).isPresent()) {
            return false; // Username already exists
        }

        // Create and save the new user
        User newUser = new User(username, password);
        userRepository.save(newUser);
        return true; // Registration successful
    }

    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
