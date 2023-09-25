package dev.praveen.productservice.services;

import dev.praveen.productservice.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public String GetAllProducts() {
        return null;
    }

    @Override
    public String GetSingleProducts(Long productId) {
        return null;
    }

    @Override
    public String AddNewProducts(ProductDto productDto) {
        return null;
    }

    @Override
    public String UpdateProduct(Long id) {
        return null;
    }

    @Override
    public String DeleteProduct(Long id) {
        return null;
    }
}
