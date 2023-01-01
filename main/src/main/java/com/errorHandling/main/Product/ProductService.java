package com.errorHandling.main.Product;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    //auto-wire the product repository
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



    //find product by id
    public Optional<Product> findProduct(Long id){



        return null;
    }




}
