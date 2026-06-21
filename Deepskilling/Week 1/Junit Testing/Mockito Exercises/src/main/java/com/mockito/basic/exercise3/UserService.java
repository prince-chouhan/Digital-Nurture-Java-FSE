package com.mockito.basic.exercise3;

/**
 * Basic Exercise 3: Argument Matching
 * UserService delegates user lookup and creation to UserRepository.
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(int id) {
        return userRepository.findUserById(id);
    }

    public boolean createUser(String username, String email) {
        return userRepository.saveUser(username, email);
    }
}
