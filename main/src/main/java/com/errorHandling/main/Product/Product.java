package com.errorHandling.main.Product;


import javax.persistence.*;

@Entity
@Table(name = "products_table")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String description;
    private double amount;
    private String imageURL;
}
