package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.model.Brand;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandMySQLDAO extends AbstractDAO<Brand> {
    public BrandMySQLDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void insertOne(Brand brand) {

    }

    @Override
    public List<Brand> getAll() {
        return null;
    }

    @Override
    public Brand getOneById(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM brands WHERE id = ?",
                (rs, rowNum) -> new Brand(id, rs.getString(2)),
                id);
    }

    @Override
    public Brand removeOneById(int id) {
        return null;
    }

    @Override
    public Brand updateOneById(int id, Brand product) {
        return null;
    }
}
