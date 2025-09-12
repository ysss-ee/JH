package com.example.demo.service;

import com.example.demo.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hp
 * @description 针对表【post】的数据库操作Service
 * @createDate 2025-08-21 14:16:31
 */
@Service
public interface PostService {
    void publishPost(Integer userId, String content);

    void deletePost(Integer userId, Integer postId);

    void updatePost(Integer userId, Integer id, String content);

    List<Post> getAllPosts();

    void reportPost(Integer userId, Integer postId, String reason);
}
