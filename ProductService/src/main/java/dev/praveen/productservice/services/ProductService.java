package dev.praveen.productservice.services;

import dev.praveen.productservice.dtos.ProductDto;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
    public String GetAllProducts();


    public String GetSingleProducts( Long productId);


    public String AddNewProducts( ProductDto productDto);


    String UpdateProduct( Long id);


    String DeleteProduct( Long id);
}

