package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Override
    Optional<PostEntity> findById(@NonNull Long id);
    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    List<PostEntity> findByOrderByLikeCountDesc(Pageable pageable);



    List<PostEntity> findByOriginalPoster(UserEntity originalPoster);


}
