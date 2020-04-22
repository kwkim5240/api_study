package com.kwkim.apidemo.service;

import com.kwkim.apidemo.domain.entity.Post;
import com.kwkim.apidemo.domain.req.PostVO;
import com.kwkim.apidemo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Object findListOfPost() {
        return postRepository.findPosts();
    };

    public Object findPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public Object createPost(PostVO postVO) {
        Post post = Post.builder()
                .title(postVO.getTitle())
                .build();

        if (postVO.getContents() != null) {
            post.setContents(postVO.getContents());
        }

        return postRepository.save(post);
    }

    public Object updatePost(Long postId, PostVO postVO) {
        Post post = postRepository.getOne(postId);
        post.setTitle(postVO.getTitle());
        post.setContents(postVO.getContents());

        return postRepository.save(post);
    }

    public Object deletePost(Long postId) {
        postRepository.deleteById(postId);
        return null;
    }
}
