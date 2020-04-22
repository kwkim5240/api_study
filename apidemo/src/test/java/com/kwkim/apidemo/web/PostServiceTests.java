package com.kwkim.apidemo.web;

import com.kwkim.apidemo.domain.req.PostVO;
import com.kwkim.apidemo.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTests {

    @Autowired
    PostService postService;

    @Test
    void findListOfPost() {
        postService.findListOfPost();
    }

    @Test
    void findPostById() {
        Long postId = 1L;
        postService.findPostById(postId);
    }

    @Test
    void createPost(PostVO postVO) {
        postService.createPost(postVO);
    }

    @Test
    void updatePost(Long postId, PostVO postVO) {
        postService.updatePost(postId, postVO);
    }

    @Test
    void deletePost(Long postId) {
        postService.deletePost(postId);
    }
}
