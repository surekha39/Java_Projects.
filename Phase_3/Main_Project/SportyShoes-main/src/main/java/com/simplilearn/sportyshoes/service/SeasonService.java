package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.dao.AbstractDAO;
import com.simplilearn.sportyshoes.dao.DAO;
import com.simplilearn.sportyshoes.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    private final DAO<Season> seasonDAO;

    @Autowired
    public SeasonService(DAO<Season> seasonDAO) {
        this.seasonDAO = seasonDAO;
    }

    public Season getSeasonFromId(int id) {
        return seasonDAO.getOneById(id);
    }

    public List<Season> getAllSeasons() {
        return seasonDAO.getAll();
    }
}
