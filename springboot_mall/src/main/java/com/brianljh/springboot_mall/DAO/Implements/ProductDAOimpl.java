package com.brianljh.springboot_mall.DAO.Implements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.brianljh.springboot_mall.DAO.ProductDAO;
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
}
