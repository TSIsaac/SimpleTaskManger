package com.taskmanager.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserProperties() {
        User user = new User(1, "username", "password");

        assertEquals(1, user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    void testSetters() {
        User user = new User(1, "oldUsername", "oldPassword");

        user.setUsername("newUsername");
        user.setPassword("newPassword");

        assertEquals("newUsername", user.getUsername());
        assertEquals("newPassword", user.getPassword());
    }
}
