package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMySQLDAO extends AbstractDAO<User> {
    public UserMySQLDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void insertOne(User user) {

    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users", mapRowToUser());
    }

    @Override
    public User getOneById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE userID = ?", mapRowToUser(), id);
    }

    @Override
    public User removeOneById(int id) {
        return null;
    }

    @Override
    public User updateOneById(int id, User product) {
        return null;
    }

    private RowMapper<User> mapRowToUser() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setPhoneNumber(rs.getString(5));
            user.setAdmin(rs.getBoolean(6));
            return user;
        };
    }

    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", mapRowToUser(), username);
    }

    public void changeUserPassword(String username, String newPassword) {
        System.out.println(username + newPassword);
        jdbcTemplate.update("UPDATE users SET password = ? WHERE username = ?", username, newPassword);
    }
}
