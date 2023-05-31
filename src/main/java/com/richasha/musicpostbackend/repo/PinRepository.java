package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.PinEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PinRepository extends JpaRepository<PinEntity, Long> {
    List<PinEntity> findAllByOwner(UserEntity owner);

    @Override
    @NonNull Optional<PinEntity> findById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);
}
