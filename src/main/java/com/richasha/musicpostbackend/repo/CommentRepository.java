package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}