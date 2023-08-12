package com.example.springcrud;

import com.example.springcrud.auth.ApplicationUserDetails;
import com.example.springcrud.model.Role;
import com.example.springcrud.model.User;
import com.example.springcrud.repository.ApplicationUserRepository;
import com.example.springcrud.service.ApplicationUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

class ApplicationUserTest {

    @InjectMocks
    private ApplicationUserService applicationUserService;
    @Mock
    private ApplicationUserRepository applicationUserRepositoryMock;
    private User user;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Set<Role> roles = new HashSet<>() {{
            add(new Role(2L, "realtor"));
        }};
        user = new User(2L, "alex1382", "pass", roles);
    }

    @Test
    void loadUserTest() {
        Mockito.when(applicationUserRepositoryMock.findApplicationUserByUsername(anyString())).thenReturn(Optional.of(user));

        ApplicationUserDetails applicationUserDetailsForReturn = applicationUserService.loadUserByUsername(user.getUsername());

        assertNotNull(applicationUserDetailsForReturn);
        assertEquals("alex1382", applicationUserDetailsForReturn.getUsername());

    }

}
