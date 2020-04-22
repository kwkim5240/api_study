package com.kwkim.apidemo;

import com.kwkim.apidemo.domain.entity.User;
import com.kwkim.apidemo.domain.req.JoinVO;
import com.kwkim.apidemo.domain.req.LoginVO;
import com.kwkim.apidemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApidemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void joinTest() {
        JoinVO joinVO = new JoinVO();
        joinVO.setUsername("TEST");
        joinVO.setPassword("123");
        joinVO.setName("ATESt");

        userService.signUp(joinVO);

        Assert.isNull(null);
    }

    @Test
    void loginTest() {
        LoginVO loginVO = new LoginVO();
        loginVO.setUsername("TEST");
        loginVO.setPassword("122");
        userService.signIn(loginVO);
    }

    //@Test
    //void logoutTest() {

    //}

    //@Test
    //void contextLoads() {
    //}

}
