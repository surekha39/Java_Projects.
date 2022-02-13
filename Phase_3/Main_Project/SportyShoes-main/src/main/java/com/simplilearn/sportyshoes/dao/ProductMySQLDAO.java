package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.service.BrandService;
import com.simplilearn.sportyshoes.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProductMySQLDAO extends AbstractDAO<Product> {

    private final SeasonService seasonService;
    private final BrandService brandService;

    @Autowired
    public ProductMySQLDAO(JdbcTemplate jdbcTemplate, SeasonService seasonService, BrandService brandService) {
        super(jdbcTemplate);
        this.seasonService = seasonService;
        this.brandService = brandService;
    }

    @Override
    public void insertOne(Product product) {
        this.jdbcTemplate.update("INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                0, product.getProductName(), product.getSeason().getSeasonId(), product.getBrand().getId(),
                product.getCategory(), product.getPrice(), product.getColor(), product.getDate().toString());
    }

    @Override
    public List<Product> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM products", mapRowToProduct());
    }

    @Override
    public Product getOneById(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM products WHERE productId = ?", mapRowToProduct(), id);
    }

    @Override
    public Product removeOneById(int id) throws DataAccessException {
        Product product = this.getOneById(id);
        jdbcTemplate.update("DELETE FROM products WHERE productId = ?", id);
        return product;
    }

    @Override
    public Product updateOneById(int id, Product product) {
        jdbcTemplate.update("UPDATE products " +
                "SET productName = ?," +
                "season = ?," +
                "brand = ?," +
                "category = ?," +
                "price = ?," +
                "productColor = ?," +
                "date = ? " +
                "WHERE productId = ?",
                product.getProductName(),
                product.getSeason().getSeasonId(),
                product.getBrand().getId(),
                product.getCategory(),
                product.getPrice(),
                product.getColor(),
                product.getDate().toString(),
                id);
        return product;
    }

    private RowMapper<Product> mapRowToProduct() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setSeason(seasonService.getSeasonFromId(rs.getInt(3)));
            product.setBrand(brandService.getBrandById(rs.getInt(4)));
            product.setCategory(rs.getString(5));
            product.setPrice(rs.getInt(6));
            product.setColor(rs.getInt(7));
            product.setDate(LocalDate.parse(rs.getDate(8).toString()));
            return product;
        };
    }


}
