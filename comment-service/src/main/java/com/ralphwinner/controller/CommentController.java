package com.ralphwinner.controller;

import com.ralphwinner.entity.Comment;
import com.ralphwinner.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    @Autowired
    public CommentService commentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/post/{id}")
    public List<Comment> findByPostId(@PathVariable Long id){
        return commentService.findByPostId(id);
    }

    @PostMapping
    public void save(@RequestBody Comment post){
        commentService.save(post);
    }
}
