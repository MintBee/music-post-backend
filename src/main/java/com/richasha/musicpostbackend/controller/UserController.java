package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.LoginDto;
import com.richasha.musicpostbackend.dto.UserDto;
import com.richasha.musicpostbackend.dto.UserRegistrationDto;
import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.mapper.entitydto.UserMapper;
import com.richasha.musicpostbackend.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        var theUserEntity = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDto(theUserEntity);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserRegistrationDto registrationDto) {
        var userEntity = userMapper.toEntity(registrationDto);
        return userMapper.toDto(userRepository.save(userEntity));
    }

    @PostMapping("/login")
    public LoginDto isUserValid(@RequestBody UserRegistrationDto registrationDto) {
        UserEntity theUser = userRepository.findByUsername(registrationDto.getUsername());
        if (theUser != null) {
            return new LoginDto(registrationDto.getPassword().equals(theUser.getPassword()));
        } else {
            return new LoginDto(false);
        }
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserRegistrationDto user)
    {
        return createUser(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
