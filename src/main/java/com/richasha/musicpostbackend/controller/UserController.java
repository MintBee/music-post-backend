package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.UserDto;
import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return convertToDto(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        var userEntity = convertToEntity(user);
        return convertToDto(userRepository.save(userEntity));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto user)
    {
        return createUser(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDto convertToDto(UserEntity userEntity) {
        if (userEntity != null) {
            return modelMapper.map(userEntity, UserDto.class);
        } else {
            return null;
        }
    }

    private UserEntity convertToEntity(UserDto userDto) {
        if (userDto != null) {
            return modelMapper.map(userDto, UserEntity.class);
        } else {
            return null;
        }
    }
}
