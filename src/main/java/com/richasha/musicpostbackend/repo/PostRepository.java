package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Override
    Optional<PostEntity> findById(@NonNull Long id);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    List<PostEntity> findAllByOrderByLikeCount(Pageable pageable);

    List<PostEntity> findByOriginalPoster(UserEntity originalPoster);


    @Query(value = "SELECT * FROM post WHERE ST_DistanceSphere(coordinate, :point) < :distance",
            nativeQuery = true)
    List<PostEntity> findByDistance(@NonNull Point point, int distance, Pageable pageable);


}
