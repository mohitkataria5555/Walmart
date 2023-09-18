package com.project.walmart.service;

import com.project.walmart.Exception.ResourceNotFoundException;
import com.project.walmart.model.Category;
import com.project.walmart.model.User;
import com.project.walmart.payload.CategoryDto;
import com.project.walmart.payload.UserDto;
import com.project.walmart.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<User> getUserById(int userId){
        Optional<User> user= Optional.ofNullable(this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User id not found")));
        return user;
    }

    public  void  deleteUser(int userId){
        User user= this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User id not found"));
        userRepository.delete(user);
    }

    public List<UserDto> viewAll(){
        List<User> findall=this.userRepository.findAll();
        List<UserDto> allDto =findall.stream().map(user -> this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());

        return allDto;
    }

    public UserDto updateUserInfo(int userId, UserDto userDto){
        User olduser=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User id not found"));
        olduser.setName(userDto.getName());
        olduser.setGender(userDto.getGender());
        olduser.setAbout(userDto.getAbout());
        olduser.setActive(userDto.isActive());
        olduser.setAddress(userDto.getAddress());
        olduser.setEmail(userDto.getEmail());
        olduser.setPassword(userDto.getPassword());
        olduser.setPhone(userDto.getPhone());
        olduser.setDate(userDto.getDate());

        User save= this.userRepository.save(olduser);

        return this.modelMapper.map(save,UserDto.class);
    }


}
