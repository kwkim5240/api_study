package com.kwkim.apidemo.service;

import com.kwkim.apidemo.domain.entity.User;
import com.kwkim.apidemo.domain.req.JoinVO;
import com.kwkim.apidemo.domain.req.LoginVO;
import com.kwkim.apidemo.exception.BadRequestException;
import com.kwkim.apidemo.exception.NotFoundException;
import com.kwkim.apidemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public Object signUp(JoinVO joinVO) {

        User user = User.builder()
                .username(joinVO.getUsername())
                .password(joinVO.getPassword())
                .name(joinVO.getName())
                .build();

        user = userRepository.save(user);

        if(user == null) {
            throw new RuntimeException(); // TODO
        }

        return user;
    }

    public User getUser(@PathVariable Long userId) {
        User user = userRepository.getOne(userId);

        if(user == null) {
            throw new NotFoundException("NotFoundUser", "not found user");
        }

        return user;
    }

    public User getUser(String username) {
        User user = userRepository.getUserByUsername(username);

        if(user == null) {
            throw new NotFoundException("NotFoundUser", "not found user");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("USER_ROLE"))
            );
        }

        return null;
    }
}
