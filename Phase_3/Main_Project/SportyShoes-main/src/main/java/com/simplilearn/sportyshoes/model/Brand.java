package com.simplilearn.sportyshoes.model;

public class Brand {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return name;
    }

    public void setBrandName(String name) {
        this.name = name;
    }
}
