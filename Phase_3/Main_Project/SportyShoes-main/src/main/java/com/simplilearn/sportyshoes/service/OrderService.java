package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.dao.DAO;
import com.simplilearn.sportyshoes.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final DAO<Order> orderDAO;

    public OrderService(DAO<Order> orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAll();
    }

    public List<Order> getFilteredOrders(String date, String category) {
        List<Order> orders = orderDAO.getAll();

        if (date != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getDate().toString().equals(date))
                    .toList();
        }
        if (category != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCategory().equals(category))
                    .toList();
        }
        return orders;
    }
}
