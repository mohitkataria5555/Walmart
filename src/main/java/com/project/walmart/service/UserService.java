package com.project.walmart.service;

import com.project.walmart.model.User;
import com.project.walmart.payload.UserDto;
import com.project.walmart.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto){
        User user=this.modelMapper.map(userDto,User.class);
        User saveUser=this.userRepository.save(user);
        UserDto saveUserDto=this.modelMapper.map(saveUser,UserDto.class);
        return saveUserDto;
    }



}
