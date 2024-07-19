package com.brianljh.springboot_mall.Service;

import com.brianljh.springboot_mall.DTO.ProductRequest;
import com.brianljh.springboot_mall.Model.Product;

public interface ProductService {
    Product getProductById(Integer product_id);

    Integer createProduct(ProductRequest productRequest);
}
