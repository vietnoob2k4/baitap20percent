package com.example.demo.service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Dto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    boolean postProduct(ProductDto productDto);

    ProductResponseDto getAllProducts(int pageNumber);

    ProductDto getProductById(Long id);

    boolean updateProduct(Long id, ProductDto productDto);  // Chỉ cần ProductDto

    void deleteProduct(Long id);
}
