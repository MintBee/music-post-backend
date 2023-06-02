package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.repo.CommentRepository;
import com.richasha.musicpostbackend.repo.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public CommentEntity createComment(CommentEntity commentEntity) {
        if (userRepository.existsByUsername(commentEntity.getCommenter().getUsername())) {
            var theUser = userRepository.findByUsername(commentEntity.getCommenter().getUsername());
            commentEntity.setCommenter(theUser);
            return commentRepository.save(commentEntity);
        } else {
            throw new NoSuchElementException("No such user singed-in for the comment.");
        }
    }

    @Override
    public void deleteComment(CommentEntity commentEntity) {
        if (commentRepository.existsById(commentEntity.getId())) {
            commentRepository.delete(commentEntity);
        }
    }

    @Override
    public void deleteCommentById(@NonNull Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        }
    }

    @Override
    public CommentEntity getComment(long commentId) throws NoSuchElementException {
        return commentRepository.findById(commentId).orElseThrow();
    }

    @Override
    public List<CommentEntity> getComments(long postId) {
        return commentRepository.findAllByPost_Id(postId);
    }


}
