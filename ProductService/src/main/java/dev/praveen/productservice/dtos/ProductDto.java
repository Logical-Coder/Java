package dev.praveen.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private  Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private Ratingdto rating;


}

//  id:1,
//          title:'...',
//          price:'...',
//          category:'...',
//          description:'...',
//          image:'...'