package com.errorHandling.main.Controller;

import com.errorHandling.main.Product.Product;
import com.errorHandling.main.Product.ProductService;
import com.errorHandling.main.Response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getProduct(@PathVariable("id") Long id){

        return ResponseHandler.responseBuilder(
                "Product found!",
                HttpStatus.ACCEPTED,
                productService.findProduct(id)
        );
    }


    @PostMapping("/add")

    public ResponseEntity addProduct(@RequestBody Product product){

        return ResponseHandler.responseBuilder(
                "product successfully added",
                HttpStatus.OK,
                productService.addProduct(product)
        );
    }




}
