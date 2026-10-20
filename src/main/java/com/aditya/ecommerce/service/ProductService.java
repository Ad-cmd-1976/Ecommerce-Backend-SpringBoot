package com.aditya.ecommerce.service;

import com.aditya.ecommerce.dto.ProductRequestDto;
import com.aditya.ecommerce.entity.Product;
import com.aditya.ecommerce.repository.ProductRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Cloudinary cloudinary;

    public ProductService(ProductRepository productRepository, Cloudinary cloudinary){
        this.productRepository = productRepository;
        this.cloudinary = cloudinary;
    }

    public List<Product> getAllProducts(){ return productRepository.findAll(); }

    public List<Product> getFeaturedProducts(){ return productRepository.findByIsFeaturedTrue(); }

    public Product createProduct(ProductRequestDto request) throws IOException {
        MultipartFile image = request.getImage();

        Map<?, ?> uploadResponse = cloudinary.uploader().upload(image.getBytes(),ObjectUtils.emptyMap());

        String imageUrl = (String) uploadResponse.get("secure_url");

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImage(imageUrl);
        product.setCategory(request.getCategory());

        return productRepository.save(product);
    }
}
