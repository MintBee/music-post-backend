package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.Post;
import com.richasha.musicpostbackend.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Optional<Post> findById(@NonNull Long id);
    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    List<Post> findAllByOrderByLikeCount(Pageable pageable);

    List<Post> findByOriginalPoster(UserEntity originalPoster);


}
