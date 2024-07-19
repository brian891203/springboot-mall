package com.brianljh.springboot_mall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brianljh.springboot_mall.DTO.ProductRequest;
import com.brianljh.springboot_mall.Model.Product;
import com.brianljh.springboot_mall.Service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Integer product_id){
        Product product = productService.getProductById(product_id);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct (@RequestBody @Valid ProductRequest productRequest) {
        Integer product_id = productService.createProduct(productRequest);

        Product product = productService.getProductById(product_id); // use the product_id to get the product

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
