package com.ralphwinner.service.impl;

import com.ralphwinner.entity.Post;
import com.ralphwinner.repo.PostRepository;
import com.ralphwinner.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    public PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        post.setPost_date_time(LocalDate.now());
        postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }
}
