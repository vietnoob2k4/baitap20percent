package com.example.demo.Dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private Double discountPrice;
    private String imageUrl;
    private String description;
    private String category;
    private String status;
}
