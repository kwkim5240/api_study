package com.kwkim.apidemo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwkim.apidemo.ApidemoApplication;
import com.kwkim.apidemo.domain.entity.Post;
import com.kwkim.apidemo.domain.req.PostVO;
import com.kwkim.apidemo.rest.PostApi;
import com.kwkim.apidemo.service.PostService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {
                ApidemoApplication.class
        }
)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostControllerTests {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pathPrefix = "/api/v1/posts";
    private PostApi postApi;

    @Value("${server.port}")
    String port;

    @BeforeAll
    void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:"+port)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        postApi = retrofit.create(PostApi.class);
    }

    @Test
    @DisplayName("Post 리스트 조회")
    void findListOfPost() throws Exception {
        Response<List<Post>> response = postApi.findListOfPost().execute();

        Assertions.assertEquals(response.code(), HttpStatus.OK.value());

        List<Post> posts = response.body();

        Assertions.assertFalse( posts.isEmpty() );

        for(Post post : posts) {
            Assertions.assertNotNull(post.getId());
            Assertions.assertNotNull(post.getTitle());
        }
    }

//    @Test
//    void findPostById() {
//        Long postId = ;
//        postService.findPostById(postId);
//    }

    @Test
    void createPost() throws Exception {
        PostVO postVO = new PostVO();
        postVO.setTitle("title1");
        postVO.setContents("content1");

        Response<Void> response = postApi.createPost(postVO).execute();

        Assertions.assertEquals(response.code(), HttpStatus.OK.value());
    }

//    @Test
//    void updatePost(Long postId, PostVO postVO) {
//        postService.updatePost(postId, postVO);
//    }

//    @Test
//    void deletePost(Long postId) {
//        postService.deletePost(postId);
//    }
}
