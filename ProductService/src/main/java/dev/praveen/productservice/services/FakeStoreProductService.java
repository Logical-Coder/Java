package dev.praveen.productservice.services;

import dev.praveen.productservice.dtos.ProductDto;
import dev.praveen.productservice.models.Category;
import dev.praveen.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<Product> GetAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products",
                ProductDto[].class
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

    @Override
    public Product GetSingleProducts(Long productId) {

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                ProductDto.class,
                productId);

        /// Getting Data from another API
        ProductDto productDto=response.getBody();
        Product product=new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());

        return product;
    }

    @Override
    public Product AddNewProducts(ProductDto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response= restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                ProductDto.class);

        ProductDto productDto=response.getBody();
        Product product1=new Product();
        product1.setId(productDto.getId());
        product1.setPrice(productDto.getPrice());
        product1.setTitle(productDto.getTitle());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product1.setCategory(category);

        product1.setDescription(productDto.getDescription());

        return product1;

    }
    @Override
    public String UpdateProduct(Long productid, Product product) {
        return null;
    }

    @Override
    public boolean DeleteProduct(Long id) {
        return false;
    }


}
