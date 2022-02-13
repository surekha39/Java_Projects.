package com.simplilearn.sportyshoes;

import com.simplilearn.sportyshoes.dao.ProductMySQLDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SportyShoesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = SpringApplication.run(SportyShoesApplication.class, args);
    }

}
