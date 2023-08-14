package com.example.otpsystemspring.controller;

import com.example.otpsystemspring.dto.UserDto;
import com.example.otpsystemspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDto getOneUser( @PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public UserDto createUser( @RequestBody UserDto user ) {
       return userService.createUser(user);
    }

    @GetMapping
    public String ping() {
        return "Pong";
    }

}
