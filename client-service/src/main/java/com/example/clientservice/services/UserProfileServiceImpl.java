package com.example.clientservice.services;

import com.example.clientservice.client.UserProfile;
import com.example.clientservice.repositories.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

//    @Autowired
//    public  UserProfileServiceImpl(UserProfileRepository userProfileRepository, UserProfileRepository userProfileRepository1){
//        this.userProfileRepository = userProfileRepository1;
//    }

    @Override
    public UserProfile getUserProfileById(int id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    @Override
    public void deleteUserProfileById(int id) {
        userProfileRepository.deleteById(id);
    }
}
