package com.example.springcrud.service;

import com.example.springcrud.auth.ApplicationUserDetails;
import com.example.springcrud.repository.ApplicationUserRepository;
import com.example.springcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser =applicationUserRepository.findApplicationUserByUsername(username);

        return new ApplicationUserDetails(optionalUser.orElseThrow(()->
                new UsernameNotFoundException("Username not found")));
    }
}
