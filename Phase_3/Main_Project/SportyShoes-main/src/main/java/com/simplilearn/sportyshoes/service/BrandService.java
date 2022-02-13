package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.dao.DAO;
import com.simplilearn.sportyshoes.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final DAO<Brand> brandDAO;

    @Autowired
    public BrandService(DAO<Brand> brandDAO) {
        this.brandDAO = brandDAO;
    }

    public Brand getBrandById(int id) {
        return this.brandDAO.getOneById(id);
    }
}
