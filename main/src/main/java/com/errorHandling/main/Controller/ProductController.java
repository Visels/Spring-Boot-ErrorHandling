package com.errorHandling.main.Controller;

import com.errorHandling.main.Product.ProductService;
import com.errorHandling.main.Response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
