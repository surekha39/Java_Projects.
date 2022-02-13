package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public void authenticateUser(String username, String pass) throws LoginException {
        User user = userService.getUserByUsername(username);
        System.out.println("bool====" + user.isAdmin());
        if (!user.isAdmin()) throw new LoginException();
        if (!(user.getUsername().equals(username) && user.getPassword().equals(pass))) throw new LoginException();
    }
}
