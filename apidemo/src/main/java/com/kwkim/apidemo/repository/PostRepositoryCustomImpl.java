package com.kwkim.apidemo.repository;

import com.kwkim.apidemo.domain.entity.Post;
import com.kwkim.apidemo.domain.entity.QPost;
import com.kwkim.apidemo.domain.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(Post.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Post> findPosts() {
        QUser user = QUser.user;
        QPost post = QPost.post;

        return from(post)
                .innerJoin(post.user, user).fetchJoin()
                .fetch();
    }
}
