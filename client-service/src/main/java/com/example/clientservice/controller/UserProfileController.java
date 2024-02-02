package com.example.clientservice.controller;


import com.example.clientservice.client.UserProfile;
import com.example.clientservice.repositories.UserProfileRepository;
import com.example.clientservice.services.UserProfileService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Data
@RestController
@RequestMapping("/profile")
public class UserProfileController {

        private final UserProfileService userProfileService;

        @GetMapping("/all")
        public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
            List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
            return ResponseEntity.ok(userProfiles);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserProfile> getUserProfileById(@PathVariable int id) {
            Optional<UserProfile> userProfile = Optional.ofNullable(userProfileService.getUserProfileById(id));
            return userProfile.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping("/create")
        public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
            UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
            return ResponseEntity.ok(createdUserProfile);
        }

        @PutMapping("/update")
        public ResponseEntity<Void> updateUserProfile(@RequestBody UserProfile userProfile) {
            userProfileService.updateUserProfile(userProfile);
            return ResponseEntity.ok().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteUserProfileById(@PathVariable int id) {
            userProfileService.deleteUserProfileById(id);
            return ResponseEntity.ok().build();
        }
}

