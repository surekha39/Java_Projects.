package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.dao.DAO;
import com.simplilearn.sportyshoes.dao.UserMySQLDAO;
import com.simplilearn.sportyshoes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final DAO<User> userDAO;

    @Autowired
    public UserService(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User getUserById(int id) {
        return userDAO.getOneById(id);
    }

    public User getUserByUsername(String username) {
        return ((UserMySQLDAO) userDAO).getUserByUsername(username);
    }

    public void changePassword(String username, String newPassword) {
        ((UserMySQLDAO) userDAO).changeUserPassword(username, newPassword);
    }
}
