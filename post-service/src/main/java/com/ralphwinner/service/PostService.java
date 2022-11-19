package com.ralphwinner.service;

import com.ralphwinner.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    void save(Post post);

    Post findById(Long id);
}
