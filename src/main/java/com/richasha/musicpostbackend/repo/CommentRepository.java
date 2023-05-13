package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.entity.PostEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPost(@NonNull PostEntity post);

    boolean existsByPost(@NonNull PostEntity post);

    @Override
    void deleteById(@NonNull Long id);
}