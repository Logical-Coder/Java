package dev.praveen.productservice.controllers;

import dev.praveen.productservice.models.Product;
import dev.praveen.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
    public List<String> GetAllCategories(){

        return categoryService.GetAllCategories();
    }


    @GetMapping("/{categoryid}")
    public List<Product> GetProductsInCategories(@PathVariable("categoryid")String categoryid){
        return categoryService.GetProductsInCategories(categoryid);
    }
}
