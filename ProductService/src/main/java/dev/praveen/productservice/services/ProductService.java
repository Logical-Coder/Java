package dev.praveen.productservice.services;

import dev.praveen.productservice.dtos.ProductDto;
import dev.praveen.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> GetAllProducts();


    Product GetSingleProducts(Long productId);

    Product AddNewProducts(
            ProductDto product
    );


    String UpdateProduct(Long productid,Product product);


    boolean DeleteProduct( Long id);
}

