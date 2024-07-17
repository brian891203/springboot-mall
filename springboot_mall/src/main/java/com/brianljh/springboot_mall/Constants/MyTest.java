package com.brianljh.springboot_mall.Constants;

// The demo of using enum and transfer between String and enum
public class MyTest {
    public static void main(String[] args) {
        ProductCategory category = ProductCategory.FOOD;
        String s = category.name();
        System.out.println(s); //println FOOD

        String s2 = "CAR";
        ProductCategory category2 = ProductCategory.valueOf(s2); // search for the enum with the name of s2 (CAR)
        System.out.println(category2); //println CAR
    }
}
 