package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.constant.ExceptionEnum;
import com.example.demo.entity.Post;
import com.example.demo.entity.Report;
import com.example.demo.exception.ApiException;
import com.example.demo.mapper.PostMapper;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.service.PostService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author hp
 * &#064;description  针对表【post】的数据库操作Service实现
 * &#064;createDate  2025-08-21 14:16:31
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private ReportMapper reportMapper;

    // 检查帖子是否存在
    private Post getPostIfExists(Integer postId) {
        Post post = postMapper.selectById(postId);
        if (post == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        return post;
    }

    // 检查帖子所有权
    private void checkPostOwnership(Post post, Integer userId) {
        if (!post.getUserId().equals(userId)) {
            throw new ApiException(ExceptionEnum.PERMISSION_NOT_ALLOWED);
        }
    }


    @Override
    public void publishPost(Integer userId, String content) {
        Post post = Post.builder()
                .userId(userId)
                .content(content)
                .build();
        postMapper.insert(post);
    }

    @Override
    public void deletePost(Integer userId, Integer postId) {
        Post post = getPostIfExists(postId);
        checkPostOwnership(post, userId);
        postMapper.deleteById(postId);

    }

    @Override
    public void updatePost(Integer userId, Integer postId, String content) {
        Post post = getPostIfExists(postId);
        checkPostOwnership(post, userId);
        post.setContent(content);
        postMapper.updateById(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.selectList(
                new LambdaQueryWrapper<Post>().orderByDesc(Post::getId)
        );
    }
    @Override
    public void reportPost(@Valid @RequestBody Integer userId, Integer postId, String reason) {
        Post post = getPostIfExists(postId);

        Report report = Report.builder()
                .userId(userId)
                .postId(postId)
                .reason(reason)
                .postContent(post.getContent())
                .approval(0)
                .build();
        reportMapper.insert(report);
    }


}