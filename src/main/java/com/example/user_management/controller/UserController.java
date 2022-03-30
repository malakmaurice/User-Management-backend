package com.example.user_management.controller;


import com.example.user_management.entity.SearchCriateria;
import com.example.user_management.entity.User;
import com.example.user_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> saveUser(@RequestBody User userRequestDto){
        return userService.saveUser(userRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByFillter(@RequestBody SearchCriateria searchCriateria){
        return userService.getUsersByFillter(searchCriateria);
    }
}
