package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.dao.AbstractDAO;
import com.simplilearn.sportyshoes.dao.DAO;
import com.simplilearn.sportyshoes.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final AbstractDAO<Product> productDAO;
    private final SeasonService seasonService;
    private final BrandService brandService;

    public ProductService(AbstractDAO<Product> pDao, SeasonService seasonService, BrandService brandService) {
        this.productDAO = pDao;
        this.seasonService = seasonService;
        this.brandService = brandService;
    }

    public void insert(Product product) {
        productDAO.insertOne(product);
    }

    public List<Product> getAllProducts() {
        return this.productDAO.getAll();
    }

    public Product getSingleById(int id) {
        return this.productDAO.getOneById(id);
    }

    public Product removeProduct(int id) {
        return this.productDAO.removeOneById(id);
    }

    public Product updateProduct(int id, Product product) {
        return productDAO.updateOneById(id, product);
    }

    public Product getProductFromMap(Map<String, String> rMap) {
        Product product = new Product();
        product.setProductId(0);
        product.setProductName(rMap.get("name"));
        product.setSeason(seasonService.getSeasonFromId(Integer.parseInt(rMap.get("season"))));
        product.setBrand(brandService.getBrandById(Integer.parseInt(rMap.get("brand"))));
        product.setCategory(rMap.get("category"));
        product.setPrice(Integer.parseInt(rMap.get("price")));
        product.setColor(Integer.parseInt(rMap.get("color")));
        product.setDate(LocalDate.parse(rMap.get("date")));
        return product;
    }

    public List<Product> getFilteredProducts(Map<String, String> searchCriteria) {
        List<Product> products = productDAO.getAll();

        return products
                .stream()
                .filter(searchCriteria.get("season") != null ? p -> p.getSeason().getName().equals(searchCriteria.get("season")) : p -> true)
                .filter(searchCriteria.get("brand") != null ? p -> p.getBrand().getBrandName().equals(searchCriteria.get("brand")) : p -> true)
                .filter(searchCriteria.get("category") != null ? p -> p.getCategory().equals(searchCriteria.get("category")) : p -> true)
                .filter(searchCriteria.get("price") != null ? p -> p.getPrice() == Integer.parseInt(searchCriteria.get("price")) : p -> true)
                .filter(searchCriteria.get("color") != null ? p -> p.getColor() == Integer.parseInt(searchCriteria.get("color")) : p -> true)
                .filter(searchCriteria.get("date") != null ? p -> p.getDate().toString().equals(searchCriteria.get("date")) : p -> true)
                .toList();
    }
}
