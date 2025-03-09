package com.taskmanager.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
    }

    @Test
    void testRegister() {
        assertTrue(authService.register("user1", "password"));
        assertFalse(authService.register("user1", "password")); // Duplicate user
    }

    @Test
    void testLoginSuccess() {
        authService.register("user1", "password");
        assertTrue(authService.login("user1", "password"));
    }

    @Test
    void testLoginFailure() {
        authService.register("user1", "password");
        assertFalse(authService.login("user1", "wrongpassword"));
        assertFalse(authService.login("unknown", "password"));
    }
}
