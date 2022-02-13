package com.simplilearn.sportyshoes.dao;

import java.util.List;

public interface DAO<T> {
    void insertOne(T t);
    List<T> getAll();
    T getOneById(int id);
    T removeOneById(int id);
    T updateOneById(int id, T product);
}
