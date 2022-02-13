package com.simplilearn.sportyshoes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {
    protected final JdbcTemplate jdbcTemplate;

    public AbstractDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
