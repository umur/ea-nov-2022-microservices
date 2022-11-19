package com.ralphwinner.controller;

import com.ralphwinner.dto.CommentDTO;
import com.ralphwinner.dto.UserDTO;
import com.ralphwinner.entity.Post;
import com.ralphwinner.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    public PostService postService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id){
        Post post = postService.findById(id);

        UserDTO user = restTemplate.getForObject("http://USER-SERVICE/api/v1/users/"+post.getUserId(), UserDTO.class);
        //CommentDTO comments = restTemplate.getForObject("http://COMMENT-SERVICE/api/v1/comments/post/"+post.getId(), CommentDTO.class);

        ResponseEntity<CommentDTO[]> response =
                restTemplate.getForEntity(
                        "http://COMMENT-SERVICE/api/v1/comments/post/"+post.getId(),
                        CommentDTO[].class);
        CommentDTO[] comments = response.getBody();


        System.out.println(user);
        System.out.println("           ----------------------");
        System.out.println(comments[0]);

        return post;
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }
}
