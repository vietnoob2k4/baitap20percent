package com.example.demo.entity;

import com.example.demo.Dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Double discountPrice;
    private String imageUrl;
    private String description;
    private String category;
    private String status;

    public ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setDiscountPrice(discountPrice);
        productDto.setImageUrl(imageUrl);
        productDto.setDescription(description);
        productDto.setCategory(category);
        productDto.setStatus(status);
        return productDto;
    }
}
