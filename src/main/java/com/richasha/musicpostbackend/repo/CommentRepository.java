package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.Comment;
import com.richasha.musicpostbackend.entity.Post;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(@NonNull Post post);

    boolean existsByPost(@NonNull Post post);

    @Override
    void deleteById(@NonNull Long id);
}