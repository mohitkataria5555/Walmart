package com.project.walmart.controller;

import com.project.walmart.model.User;
import com.project.walmart.payload.UserDto;
import com.project.walmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/findById/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int userId){
        Optional<User> user = this.userService.getUserById(userId);
        return new ResponseEntity<Optional<User>>(user,HttpStatus.FOUND);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteTheUser(@PathVariable int userId){
       userService.deleteUser(userId);
       return new ResponseEntity<String>("User Deleted",HttpStatus.ACCEPTED);
    }

    @GetMapping("/view")
    public ResponseEntity<List<UserDto>> viewAllUsers(){
        List<UserDto> userDto= this.userService.viewAll();
        return new ResponseEntity<List<UserDto>>(userDto,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable int userId,@RequestBody UserDto userDto ){
        Date dated= new Date();
        userDto.setDate(dated);
        UserDto updateUser=this.userService.updateUserInfo(userId,userDto);
        return new ResponseEntity<UserDto>(updateUser,HttpStatus.ACCEPTED);
    }



}
