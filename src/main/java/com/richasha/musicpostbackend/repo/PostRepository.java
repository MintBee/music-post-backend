package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.Post;
import com.richasha.musicpostbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Optional<Post> findById(Long id);
    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    List<Post> findByOriginalPoster(User originalPoster);
}
