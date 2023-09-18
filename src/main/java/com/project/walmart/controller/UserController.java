package com.project.walmart.controller;

import com.project.walmart.payload.UserDto;
import com.project.walmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        Date dated= new Date();
        userDto.setDate(dated);
        UserDto createuser=this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createuser, HttpStatus.CREATED);
    }



}
