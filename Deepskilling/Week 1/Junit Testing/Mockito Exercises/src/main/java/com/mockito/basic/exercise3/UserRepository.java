package com.mockito.basic.exercise3;

/**
 * Basic Exercise 3: Argument Matching
 * UserRepository defines the data access contract whose arguments are matched in tests.
 */
public interface UserRepository {

    String findUserById(int id);

    boolean saveUser(String username, String email);
}
