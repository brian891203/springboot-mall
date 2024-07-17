package com.brianljh.springboot_mall.Service.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brianljh.springboot_mall.DAO.ProductDAO;
import com.brianljh.springboot_mall.Model.Product;
import com.brianljh.springboot_mall.Service.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product getProductById(Integer product_id) {
        return productDAO.getProductById(product_id);
    }
}
