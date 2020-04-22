package com.kwkim.apidemo.repository;

import com.kwkim.apidemo.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    Post getPostByTitle(String title);
}
