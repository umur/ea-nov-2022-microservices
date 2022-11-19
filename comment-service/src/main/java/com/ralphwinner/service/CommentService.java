package com.ralphwinner.service;

import com.ralphwinner.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    void save(Comment post);

    List<Comment> findByPostId(Long postId);

    Comment findById(Long id);
}
