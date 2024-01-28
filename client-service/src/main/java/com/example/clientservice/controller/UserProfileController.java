package com.example.clientservice.controller;


import com.example.clientservice.client.UserProfile;
import com.example.clientservice.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/{username}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String username) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUsername(username);
        return userProfile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Другие методы для обновления, создания и удаления профиля
}
