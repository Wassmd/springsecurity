package com.paxier.springsecurity.service;

import com.paxier.springsecurity.entity.UserEntity;
import com.paxier.springsecurity.persistence.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserJpaRepository userJpaRepository;
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        log.debug("Saving user...");
       return userJpaRepository.save(user);
    }
}
