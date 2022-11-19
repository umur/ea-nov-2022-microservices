package com.ralphwinner.service.impl;

import com.ralphwinner.entity.Comment;
import com.ralphwinner.repo.CommentRepository;
import com.ralphwinner.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    public CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        comment.setInsDateTime(LocalDate.now());
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }
}
