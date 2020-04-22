package com.kwkim.apidemo.web;

import com.kwkim.apidemo.domain.req.PostVO;
import com.kwkim.apidemo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public Object findListOfPost() {
        return postService.findListOfPost();
    }

    @GetMapping("/{postId}")
    public Object findPostById(@PathVariable Long postId) {
        return findPostById(postId);
    }

    @PostMapping("")
    public Object createPost(@RequestBody PostVO postVO) {
        return postService.createPost(postVO);
    }

    @PutMapping("/{postId}")
    public Object updatePost(@PathVariable Long postId,
                             @RequestBody PostVO postVO) {
        return postService.updatePost(postId, postVO);
    }

    @DeleteMapping("/{postId}")
    public Object deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }
}
