package com.aditya.ecommerce.controller;

import com.aditya.ecommerce.entity.Product;
import com.aditya.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public Map<String, List<Product>> getAllProducts(){
        return Map.of("products", productService.getAllProducts());
    }

    @GetMapping("/getFeaturedProducts")
    public List<Product> getFeaturedProducts(){
        return productService.getFeaturedProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
