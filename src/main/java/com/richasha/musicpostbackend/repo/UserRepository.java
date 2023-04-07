package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAuthId(String authId);

    User findByNickname(String nickname);

    boolean existsByNickname(String nickname);

    boolean existsByAuthId(String authId);
}