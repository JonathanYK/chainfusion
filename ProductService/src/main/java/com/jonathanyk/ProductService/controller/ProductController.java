package com.jonathanyk.ProductService.controller;

import com.jonathanyk.ProductService.dto.ProductRequest;
import com.jonathanyk.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getProducts(@RequestParam(required = false) String productId) {
        if (productId != null) return ResponseEntity.ok(productService.getProductById(productId));
        else return ResponseEntity.ok(productService.getAllProducts());
    }

}
