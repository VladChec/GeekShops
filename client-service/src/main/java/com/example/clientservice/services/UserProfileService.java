package com.example.clientservice.services;

import com.example.clientservice.client.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile getUserProfileById(int id);
    List<UserProfile> getAllUserProfiles();
    UserProfile createUserProfile(UserProfile userProfile);
    public void updateUserProfile(UserProfile userProfile);

    public void deleteUserProfileById(int id);
}
