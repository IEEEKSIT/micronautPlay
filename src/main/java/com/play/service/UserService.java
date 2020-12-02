package com.play.service;

import com.play.dao.User;
import com.play.repository.UserRepository;
import io.micronaut.core.annotation.Introspected;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Introspected
@Slf4j
public class UserService {
    @Inject
    private UserRepository userRepository;

    public List<User> findAll() {
        long startTime = System.currentTimeMillis();
        List<User> users = userRepository.findAll();
        log.info("time taken is {}", System.currentTimeMillis() - startTime);
        return users;
    }

    public Optional<User> findUserByEmail(String email) {
        long startTime = System.currentTimeMillis();
        Optional<User> userOptional = userRepository.findTop1ByEmailOrderByCreatedOnDesc(email);
        log.info("time taken is {}", System.currentTimeMillis() - startTime);
        return userOptional;
    }
}
