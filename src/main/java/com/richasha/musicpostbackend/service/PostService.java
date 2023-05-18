package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.dto.PointDto;
import com.richasha.musicpostbackend.entity.PostEntity;
import org.locationtech.jts.geom.Point;

import java.util.List;


public interface PostService {
    List<PostEntity> getPaginatedPosts(int page, int size) throws Exception;

    List<PostEntity> getPaginatedPostsByDistance(int page, int size, Point point,
                                                 double distance);
    PostEntity getPostById(Long postId) throws Exception;

    PostEntity createPost(PostEntity post) throws Exception;

    List<PostEntity> getRelatedPostsById(Long postId) throws Exception;
}
