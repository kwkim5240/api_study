package com.kwkim.apidemo.web;

import com.kwkim.apidemo.domain.entity.User;
import com.kwkim.apidemo.domain.req.JoinVO;
import com.kwkim.apidemo.domain.req.LoginVO;
import com.kwkim.apidemo.exception.NotFoundException;
import com.kwkim.apidemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @PostMapping("/join")
    public Object signUp(@RequestBody JoinVO joinVO) {
        joinVO.setPassword( passwordEncoder.encode(joinVO.getPassword()) );

        userService.signUp(joinVO);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/signin")
    public Object signIn(@RequestBody LoginVO loginVO, HttpSession session) {
        loginVO.setPassword( loginVO.getPassword() );

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                loginVO.getUsername(),
                loginVO.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("USER_ROLE"))
        );

        Authentication auth = authenticationManager.authenticate(authToken);

        if(auth == null) {
            throw new NotFoundException("NotFoundUser", "not found user");
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        session.setAttribute(
            HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext()
        );

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public Object getUser(@PathVariable Long userId) {
        return null;
    }
}
