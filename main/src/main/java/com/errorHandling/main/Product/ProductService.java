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

        Optional<Product> foundProduct = productRepository.findById(id);

        if(!foundProduct.isPresent()){
            throw new IllegalStateException("product could not be found!");
        }

        return foundProduct;
    }


    //add product
    public Product addProduct(Product newProduct){

        Optional<Product> availableProduct = productRepository.findById(newProduct.getId());

        if(availableProduct.isPresent()){
            throw new IllegalStateException("Product already present");
        }

        //save the product
        productRepository.save(newProduct);

        return newProduct;
    }




}
