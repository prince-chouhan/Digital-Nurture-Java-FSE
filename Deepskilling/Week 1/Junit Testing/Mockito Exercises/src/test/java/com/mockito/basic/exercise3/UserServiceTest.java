package com.mockito.basic.exercise3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Basic Exercise 3: Argument Matching
*/
public class UserServiceTest {

    @Test
    void testGetUserWithExactArgument() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);

        when(mockRepo.findUserById(eq(1))).thenReturn("Alice");

        UserService service = new UserService(mockRepo);
        String result = service.getUser(1);

        assertEquals("Alice", result);
        verify(mockRepo).findUserById(eq(1));
    }

    @Test
    void testGetUserWithAnyIntMatcher() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);

        when(mockRepo.findUserById(anyInt())).thenReturn("AnyUser");

        UserService service = new UserService(mockRepo);
        String result = service.getUser(42);

        assertEquals("AnyUser", result);
        verify(mockRepo).findUserById(anyInt());
    }

    @Test
    void testCreateUserWithAnyStringMatchers() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);

        when(mockRepo.saveUser(anyString(), anyString())).thenReturn(true);

        UserService service = new UserService(mockRepo);
        boolean saved = service.createUser("bob", "bob@example.com");

        assertTrue(saved);
        verify(mockRepo).saveUser(anyString(), anyString());
    }
}
