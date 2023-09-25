package dev.praveen.productservice.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryService implements CategoryService{
    @Override
    public String GetAllCategories() {
        return null;
    }

    @Override
    public String GetProductsInCategories(Long categoryid) {
        return null;
    }
}
