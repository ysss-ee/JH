package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j

public class PostController {
    @Resource

    private PostService postService;


    @PostMapping("/student/post")
    public Result<Void> publishPost(@Valid @RequestBody PublishPostRequest post) {
        postService.publishPost(post.getUserId(), post.getContent());
        return Result.success();


    }

    @PutMapping("/student/post")
    public Result<Void> updatePost(@Valid @RequestBody UpdatePostRequest post) {
        postService.updatePost(post.getUserId(), post.getPostId(), post.getContent());
        return Result.success();

    }

    @DeleteMapping("/student/post")
    public Result<Void> deletePost(@Valid @RequestBody DeletePostRequest post) {
        postService.deletePost(post.getUserId(), post.getPostId());
        return Result.success();

    }

    @GetMapping("/student/post")
    public Result<List<Post>>getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return Result.success(posts);

    }

    @PostMapping("/student/report_post")
    public Result<Void> reportPost(@Valid @RequestBody ReportPostsRequest request) {
        postService.reportPost(request.getUserId(), request.getPostId(), request.getReason());
        return Result.success();
    }
}






