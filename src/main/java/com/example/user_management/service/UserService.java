package com.example.user_management.service;

import com.example.user_management.entity.SearchCriateria;
import com.example.user_management.entity.Status;
import com.example.user_management.entity.User;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.repository.customUserReposotory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final customUserReposotory customUserReposotory;

    public List<User> saveUser(User userRequestDto){
        userRequestDto.setUserStatus(Status.Inactive);
        userRequestDto.setCreated(Instant.now());
        userRepository.save(userRequestDto);
        System.out.println(userRequestDto);
        return getAllUsers();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByFillter(SearchCriateria searchCriateria){
       //  =new SearchCriateria("test",Status.Active,"","");
        return customUserReposotory.search(searchCriateria);
    }


}
