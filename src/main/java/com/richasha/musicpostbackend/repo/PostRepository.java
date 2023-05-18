package com.richasha.musicpostbackend.repo;

import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    default List<PostEntity> findAllNearby(
            double longitude,
            double latitude,
            double searching_radius
    ) {
        Pageable pageable = PageRequest.of(0, (int)this.count());
        return findAllNearby(longitude, latitude, searching_radius, pageable);
    }

    @Query(
            value = "SELECT p FROM post p " +
                    "WHERE st_distancesphere(st_makepoint(:longitude, :latitude)," +
                    "st_makepoint(st_x(p.coordinate), st_y(p.coordinate))) < :radiusu"
            , nativeQuery = true
    )
    List<PostEntity> findAllNearby(
            @Param("longitude") double longitude,
            @Param("latitude") double latitude,
            @Param("radius") double searching_radius,
            Pageable pageable
    );
}
