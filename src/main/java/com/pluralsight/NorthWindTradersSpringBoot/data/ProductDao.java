package com.pluralsight.NorthWindTradersSpringBoot.data;

import com.pluralsight.NorthWindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public void add(Product product);
}