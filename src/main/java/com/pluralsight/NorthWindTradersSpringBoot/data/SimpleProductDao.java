package com.pluralsight.NorthWindTradersSpringBoot.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        this.products.add(new Product(1, "Test Product", "Produce", 123));
        this.products.add(new Product(2, "Test Product", "Sea Food", 145));
        this.products.add(new Product(3, "Test Product", "Dairy Food", 167));
    }

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
        System.out.println(product);
    }
}
