package com.example.springcrud.service;

import com.example.springcrud.persistence.entity.UserEntity;
import com.example.springcrud.persistence.mapper.UserMapper;
import com.example.springcrud.persistence.repository.ApplicationUserRepository;
import com.example.springcrud.security.ApplicationUserDetails;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final UserMapper userMapper;

    @Override
    public ApplicationUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity = applicationUserRepository.findApplicationUserByUsername(username);
        var userEntity = optionalUserEntity.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        var user = userMapper.toDto(userEntity);

        return new ApplicationUserDetails(user);
    }
}
