package com.richasha.musicpostbackend.service;


import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.repo.PostRepository;
import com.richasha.musicpostbackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    // metric: meters
    public static final int SEARCHING_RADIUS = 50;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<PostEntity> getPaginatedPosts(int page, int size) throws Exception {
        return postRepository.findByOrderByLikeCountDesc(PageRequest.of(page, size));
    }

    @Override
    public List<PostEntity> getPaginatedPostsByDistance(int page, int size, Point point,
                                                        double distance) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAllNearby(point.getX(), point.getY(), distance, pageable);
    }

    private List<PostEntity> getPostsByDistance(int limit, Point point, double distance) {
        return getPaginatedPostsByDistance(0, limit, point, distance);
    }

    @Override
    public PostEntity getPostById(Long postId) throws Exception {
        return postRepository.findById(postId).orElseThrow();
    }

    @Override
    public PostEntity createPost(PostEntity post) {
        UserEntity poster = userRepository.findByUsername(post.getOriginalPoster().getUsername());
        post.setOriginalPoster(poster);
        return postRepository.save(post);
    }

    @Override
    public List<PostEntity> getRelatedPostsById(Long postId) throws Exception {
        int relatedPostLimit = 3;
        List<PostEntity> resultPosts = new ArrayList<>();
        if (postRepository.existsById(postId)) {
            PostEntity thePost = postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
            List<PostEntity> allPosts = getPostsByDistance(Integer.MAX_VALUE,
                    thePost.getCoordinate(), 300);
            List<PostEntity> postsWithSameArtist = findPostsWithSameArtist(thePost, allPosts, relatedPostLimit);
            resultPosts.addAll(postsWithSameArtist);
            if (postsWithSameArtist.size() < relatedPostLimit) {
                int leftPostCount = relatedPostLimit - postsWithSameArtist.size();
                resultPosts.addAll(getFillingPosts(leftPostCount, allPosts, postsWithSameArtist));
            }
            return resultPosts;
        } else {
            throw new NoSuchElementException("No such post of id: " + postId.toString());
        }
    }

    private static List<PostEntity> findPostsWithSameArtist(PostEntity thePost, List<PostEntity> allPosts, int relatedPostLimit) {
        String artistOfThePost = thePost.getMusic().getArtist();
        return allPosts.stream()
                .filter(post -> post.getMusic().getArtist().equals(artistOfThePost) && !post.getId().equals(thePost.getId()))
                .limit(relatedPostLimit).toList();
    }

    private Collection<PostEntity> getFillingPosts(int leftPostsCount,
                                                   List<PostEntity> source,
                                                   List<PostEntity> alreadyAddedPosts) {
        int notAddedPostsCount = source.size() - alreadyAddedPosts.size();
        List<Integer> sequentialInts = new ArrayList<>(IntStream.range(0, notAddedPostsCount).boxed().toList());
        Collections.shuffle(sequentialInts);
        return source.stream()
                .filter(post -> alreadyAddedPosts.stream().noneMatch(addedPost -> addedPost.getId().equals(post.getId())))
                .limit(leftPostsCount)
                .toList();


    }
}
