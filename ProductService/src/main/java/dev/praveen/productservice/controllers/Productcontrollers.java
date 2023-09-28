package dev.praveen.productservice.controllers;


import dev.praveen.productservice.dtos.AddNewProductRequestdto;
import dev.praveen.productservice.dtos.GetSingleProductResponsedto;
import dev.praveen.productservice.dtos.ProductDto;
import dev.praveen.productservice.models.Product;
import dev.praveen.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class Productcontrollers  {

    private ProductService productService;
    public Productcontrollers(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public List<Product> GetAllProducts(){
        return productService.GetAllProducts();


    }

    @GetMapping("/{productID}")
    public ResponseEntity<GetSingleProductResponsedto> GetSingleProducts(@PathVariable("productID") Long productId){

        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
        headers.add("Auth_token","success");
        ResponseEntity<GetSingleProductResponsedto> response=new  ResponseEntity(

                productService.GetSingleProducts(productId),
                headers,
                HttpStatus.NOT_FOUND
        );


        return response;

//        public ResponseEntity<Product> GetSingleProducts(@PathVariable("productID") Long productId){
//
//        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
//        headers.add("Auth_token","success");
//        ResponseEntity<Product> response=new  ResponseEntity(
//
//                productService.GetSingleProducts(productId),
//                headers,
//                HttpStatus.NOT_FOUND
//        );


//        return response;
    }

//    }

    @PostMapping("")
    public ResponseEntity<Product>  AddNewProducts(@RequestBody ProductDto product){
        Product newproduct=productService.AddNewProducts(
                product
        );
        ResponseEntity<Product> response=new ResponseEntity<>(newproduct,
                HttpStatus.OK);
        return response;
    }

    @PutMapping("/Updateproducts/{productid}")
    public String UpdateProduct(@PathVariable("productid") Long id){
        return "UpdateProduct"+id;

    }

    @DeleteMapping("/deleteproduct/{productid}")
    public  String DeleteProduct(@PathVariable("productid") Long id){
        return "Delete a Product"+id;
    }


}
