package dev.praveen.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewProductRequestdto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
