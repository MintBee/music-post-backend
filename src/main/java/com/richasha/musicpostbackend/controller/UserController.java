package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.entity.AppUserDetail;
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
    public AppUserDetail getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public AppUserDetail createUser(@RequestBody AppUserDetail user) {
        return userRepository.save(user);
    }

    @PutMapping
    public AppUserDetail updateUser(@RequestBody AppUserDetail user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody AppUserDetail user) {
        userRepository.delete(user);
    }
}
