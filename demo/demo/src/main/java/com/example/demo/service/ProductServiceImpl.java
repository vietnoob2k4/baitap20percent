package com.example.demo.service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public boolean postProduct(ProductDto productDto) {
        try {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDiscountPrice(productDto.getDiscountPrice());
            product.setImageUrl(productDto.getImageUrl());
            product.setDescription(productDto.getDescription());
            product.setCategory(productDto.getCategory());
            product.setStatus(productDto.getStatus());

            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ProductResponseDto getAllProducts(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 30);
        Page<Product> productPage = productRepository.findAll(pageable);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setPageNumber(productPage.getPageable().getPageNumber());
        productResponseDto.setTotalPages(productPage.getTotalPages());
        productResponseDto.setProductDtoList(productPage.stream().map(Product::getProductDto).collect(Collectors.toList()));
        return productResponseDto;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get().getProductDto();
        } else {
            throw new EntityNotFoundException("Product not found");
        }
    }

    @Override
    public boolean updateProduct(Long id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(productDto.getName());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setDiscountPrice(productDto.getDiscountPrice());
            existingProduct.setImageUrl(productDto.getImageUrl());
            existingProduct.setDescription(productDto.getDescription());
            existingProduct.setCategory(productDto.getCategory());
            existingProduct.setStatus(productDto.getStatus());
            productRepository.save(existingProduct);
            return true;
        }
        return false;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product not found");
        }
    }
}
