package com.kwkim.apidemo.rest;

import com.kwkim.apidemo.domain.entity.Post;
import com.kwkim.apidemo.domain.req.PostVO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface PostApi {
    @GET("/api/v1/posts")
    Call<List<Post>> findListOfPost();

    @GET("/api/v1/posts/{postId}")
    Call<Post> findPostById(@Path("postId") Long postId);

//    @POST("/api/v1/posts")
//    @FormUrlEncoded
//    Call<Void> createPost(@FieldMap Map<String, Object> params);

//    @POST("/api/v1/posts")
//    @FormUrlEncoded
//    Call<Void> createPost(
//            @Field("title") String title,
//            @Field("contents") String contents
//    );

    @POST("/api/v1/posts")
    Call<Void> createPost(@Body PostVO postVO);


}
