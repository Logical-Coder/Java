package dev.praveen.productservice.controllers;

import dev.praveen.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
    public String GetAllCategories(){
        return "Getting All Categories";
    }

    @GetMapping("/{categoryid}")
    public String GetProductsInCategories(@PathVariable("categoryid")Long categoryid){
        return "Returning Categories "+categoryid;
    }
}
