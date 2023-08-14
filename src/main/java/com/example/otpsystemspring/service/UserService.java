package com.example.otpsystemspring.service;


import com.example.otpsystemspring.dto.UserDto;
import com.example.otpsystemspring.entity.Users;

public interface UserService {

    UserDto createUser( UserDto user);
    UserDto getUser( long id);


}
