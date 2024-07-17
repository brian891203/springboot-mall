package com.brianljh.springboot_mall.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brianljh.springboot_mall.Constants.ProductCategory;
import com.brianljh.springboot_mall.Model.Product;

// RowMapper<Product> --> means that the RowMapper transfers to product java class
// Set the product query from database to transfer to product java class and return
// RowMapper<Product> --> Just like raw data and java class mapping
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));

        // product.setCategory(rs.getString("category"));
        String ProductCategoryStr = rs.getString("category");
        // .valueOf -->  Seearch the ProductCategoryStr in ProductCategory enum and return the result 
        ProductCategory category = ProductCategory.valueOf(ProductCategoryStr);
        product.setCategory(category);

        // equal to the above three lines of code
        // product.setCategory(ProductCategory.valueOf(rs.getString("category")));

        product.setImage_url(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.setDescription(rs.getString("description"));
        product.setCreated_date(rs.getDate("created_date"));
        product.setLast_modified_date(rs.getDate("last_modified_date"));
        
        return product;
    }
     
}
