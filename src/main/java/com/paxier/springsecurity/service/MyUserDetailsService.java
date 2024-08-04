package com.paxier.springsecurity.service;

import com.paxier.springsecurity.entity.UserEntity;
import com.paxier.springsecurity.model.UserPrincipal;
import com.paxier.springsecurity.persistence.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    UserJpaRepository userRepo;

    public MyUserDetailsService(UserJpaRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("Requested user: "+ username + "not found");
        }
        System.out.println("User found:"+user);
        return new UserPrincipal(user);
    }
}
