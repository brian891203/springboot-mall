package com.brianljh.springboot_mall.DAO;

import com.brianljh.springboot_mall.DTO.ProductRequest;
import com.brianljh.springboot_mall.Model.Product;

public interface ProductDAO {
    Product getProductById(Integer product_id);

    Integer createProduct(ProductRequest productRequest);
}
