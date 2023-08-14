package com.example.otpsystemspring.service.Impl;

import com.example.otpsystemspring.dto.UserDto;
import com.example.otpsystemspring.entity.Users;
import com.example.otpsystemspring.repository.UserRepository;
import com.example.otpsystemspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser( UserDto user ) {

        Users users = new Users();
        users.setUserName(user.getUsername());
        users = userRepository.save(users);

        return convertToDto(users);
    }

    private UserDto convertToDto( Users users ) {
        UserDto dto = new UserDto();

        dto.setId(users.getId());
        dto.setUsername(users.getUserName());
        return dto;
    }

    @Override
    public UserDto getUser( long id ) {
        Users user = userRepository.getUserById(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUserName());
        return userDto;
    }
}
