package dev.praveen.productservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


public interface CategoryService {

    public String GetAllCategories();

    public String GetProductsInCategories(Long categoryid);

}
