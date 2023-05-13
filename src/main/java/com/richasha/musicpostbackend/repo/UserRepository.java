package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.AppUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUserDetail, Long> {
    AppUserDetail findByAuthId(String authId);

    AppUserDetail findByNickname(String nickname);

    boolean existsByNickname(String nickname);

    boolean existsByAuthId(String authId);
}