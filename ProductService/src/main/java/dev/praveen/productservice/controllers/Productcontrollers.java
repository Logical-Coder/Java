package dev.praveen.productservice.controllers;


import dev.praveen.productservice.dtos.ProductDto;
import dev.praveen.productservice.services.CategoryService;
import dev.praveen.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class Productcontrollers  {

    private ProductService productService;
    public Productcontrollers(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public String GetAllProducts(){
    return "Getting All Products";
    }

    @GetMapping("/{productID}")
    public String GetSingleProducts(@PathVariable("productID") Long productId){
        return "SingleProducts  "+productId;
    }

    @PostMapping("/")
    public String AddNewProducts(@RequestBody ProductDto productDto){
        return "Add new Product" + productDto;
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
