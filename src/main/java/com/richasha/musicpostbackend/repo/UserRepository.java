package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface    UserRepository extends JpaRepository<UserEntity, Long> {
    @Transactional
    @Modifying
    @Query("update UserEntity u set u.password = ?1 where u.username = ?2")
    void updatePasswordByUsername(String password, String username);
    UserEntity findByUsername(String username);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);
}