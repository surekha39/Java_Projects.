package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeasonMySQLDAO extends AbstractDAO<Season> {

    @Autowired
    public SeasonMySQLDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void insertOne(Season season) {

    }

    @Override
    public List<Season> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM seasons", (rs, rowNum) -> {
            Season season = new Season();
            season.setSeasonId(rs.getInt(1));
            season.setName(rs.getString(2));
            return season;
        });
    }

    @Override
    public Season getOneById(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM seasons WHERE seasonId = ?", (rs, rowNum) -> {
            Season season = new Season();
            season.setSeasonId(rs.getInt(1));
            season.setName(rs.getString(2));
            return season;
        }, id);
    }

    @Override
    public Season removeOneById(int id) {
        return null;
    }

    @Override
    public Season updateOneById(int id, Season product) {
        return null;
    }
}
