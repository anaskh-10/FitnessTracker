package com.ilPatron.fitnessTrackerServer.controller;

import com.ilPatron.fitnessTrackerServer.dto.UserLoginDTO;
import com.ilPatron.fitnessTrackerServer.dto.UserRegisterDTO;
import com.ilPatron.fitnessTrackerServer.entity.User;
import com.ilPatron.fitnessTrackerServer.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    private  final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDTO request) {
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password are required!");
        }

        if (userService.register(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok("User registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists!");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO request, HttpSession session) {
        if (userService.authenticate(request.getUsername(), request.getPassword())) {
            User user = userService.getUserByUsername(request.getUsername()).orElse(null);
            if (user != null) {
                session.setAttribute("userId", user.getId());
                System.out.println("User logged in with ID: " + user.getId()); // Debug statement
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found!");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Clear the session
        return ResponseEntity.ok("Logged out successfully!");
    }
}
