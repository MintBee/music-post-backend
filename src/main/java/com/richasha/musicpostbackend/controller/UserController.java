package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// controller to do crud operations on users
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserEntity user) {
        userRepository.delete(user);
    }
}
