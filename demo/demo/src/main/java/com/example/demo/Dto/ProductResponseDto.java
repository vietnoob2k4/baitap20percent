package com.example.demo.Dto;


import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private List<ProductDto> productDtoList;
    private Integer totalPages;
    private Integer pageNumber;
}
