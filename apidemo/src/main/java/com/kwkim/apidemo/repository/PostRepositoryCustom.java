package com.kwkim.apidemo.repository;

import com.kwkim.apidemo.domain.entity.Post;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> findPosts();
}

