package com.brianljh.springboot_mall.DAO.Implements;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.brianljh.springboot_mall.DAO.ProductDAO;
import com.brianljh.springboot_mall.DTO.ProductRequest;
import com.brianljh.springboot_mall.Model.Product;
import com.brianljh.springboot_mall.RowMapper.ProductRowMapper;

@Component
public class ProductDAOimpl implements ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer product_id) {
        // SQL query to get product by product_id
        // :product_id is a placeholder for the actual product_id (above method parameter)
        String sql = 
            "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :product_id;";
        
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", product_id);

        List<Product> ProductList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (ProductList.size() > 0) {
            // return the product query by product_id
            return ProductList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = 
            "INSERT INTO product (product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES (DEFAULT, :product_name, :category, :image_url, :price, :stock, :description, :created_date, :last_modified_date)";
        Map<String, Object> map = new HashMap<>();
        map.put("product_name", productRequest.getProduct_name());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImage_url());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("created_date", now);
        map.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder(); // store the id generated from database

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int product_id = keyHolder.getKey().intValue(); 

        return product_id;
    }

    
}
