package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.entity.PostEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByPost_Id(Long id);

    boolean existsByPost(@NonNull PostEntity post);


    @Override
    void deleteById(@NonNull Long id);
}