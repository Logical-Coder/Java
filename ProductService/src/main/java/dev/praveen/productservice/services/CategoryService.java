package dev.praveen.productservice.services;

import dev.praveen.productservice.models.Product;

import java.util.List;


public interface CategoryService {

    public List<String> GetAllCategories();

    public List<Product> GetProductsInCategories(String categoryid);

}
