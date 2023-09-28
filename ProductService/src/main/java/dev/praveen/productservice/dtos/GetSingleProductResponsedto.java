package dev.praveen.productservice.dtos;

import dev.praveen.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponsedto {
    private Product product;
}
