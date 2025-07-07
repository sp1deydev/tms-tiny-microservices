package com.thientdk.be_tms.controllers;

import com.thientdk.be_tms.models.requests.ProductRequest;
import com.thientdk.be_tms.models.responses.TextResponse;
import com.thientdk.be_tms.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public TextResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

}
