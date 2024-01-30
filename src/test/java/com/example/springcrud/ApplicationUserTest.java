package com.example.springcrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.springcrud.auth.ApplicationUserDetails;
import com.example.springcrud.entity.RoleEntity;
import com.example.springcrud.entity.UserEntity;
import com.example.springcrud.repository.ApplicationUserRepository;
import com.example.springcrud.service.ApplicationUserService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ApplicationUserTest {

    @InjectMocks
    private ApplicationUserService applicationUserService;

    @Mock
    private ApplicationUserRepository applicationUserRepositoryMock;
    private UserEntity userEntity;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Set<RoleEntity> roleEntities = new HashSet<>() {{
            add(new RoleEntity(2L, "realtor"));
        }};
        userEntity = new UserEntity(2L, "alex1382", "pass", roleEntities);
    }

    @Test
    void loadUserTest() {
        when(applicationUserRepositoryMock.findApplicationUserByUsername(anyString()))
            .thenReturn(Optional.of(userEntity));

        ApplicationUserDetails applicationUserDetailsForReturn = applicationUserService.loadUserByUsername(
            userEntity.getUsername());

        assertNotNull(applicationUserDetailsForReturn);
        assertEquals("alex1382", applicationUserDetailsForReturn.getUsername());

    }

}