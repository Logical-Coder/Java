package dev.praveen.productservice.services;

import dev.praveen.productservice.dtos.ProductDto;
import dev.praveen.productservice.models.Category;
import dev.praveen.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<String> GetAllCategories() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        String[] categories= restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                String[].class
        );

        return List.of(categories);


    }

    @Override
    public List<Product> GetProductsInCategories(String categoryid) {

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products/category/{id}",
                ProductDto[].class,
                categoryid
        );
        List<Product> answer=new ArrayList<>();
        for(ProductDto productDto:l.getBody()){
            Product product=new Product();
            product.setId(productDto.getId());
            product.setPrice(productDto.getPrice());
            product.setTitle(productDto.getTitle());
            Category category=new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setDescription(productDto.getDescription());
            answer.add(product);
        }
        return answer;
    }
}
