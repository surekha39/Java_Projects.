package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.model.Order;
import com.simplilearn.sportyshoes.service.ProductService;
import com.simplilearn.sportyshoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderMySQLDAO extends AbstractDAO<Order> {
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public OrderMySQLDAO(JdbcTemplate jdbcTemplate, ProductService productService, UserService userService) {
        super(jdbcTemplate);
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void insertOne(Order order) {

    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query("SELECT * FROM productorders", (rs, rowNum) -> {
            Order order = new Order();
            order.setUser(userService.getUserById(rs.getInt(1)));
            order.setProduct(productService.getSingleById(rs.getInt(2)));
            return order;
        });
    }

    @Override
    public Order getOneById(int id) {
        return null;
    }

    @Override
    public Order removeOneById(int id) {
        return null;
    }

    @Override
    public Order updateOneById(int id, Order product) {
        return null;
    }
}
