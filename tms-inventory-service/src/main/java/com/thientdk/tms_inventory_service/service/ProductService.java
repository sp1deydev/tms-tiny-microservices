package com.thientdk.tms_inventory_service.service;

import com.thientdk.tms_inventory_service.aop.exceptions.ApiException;
import com.thientdk.tms_inventory_service.aop.exceptions.ErrorCode;
import com.thientdk.tms_inventory_service.entities.ProductEntity;
import com.thientdk.tms_inventory_service.models.requests.ProductRequest;
import com.thientdk.tms_inventory_service.models.responses.ProductResponse;
import com.thientdk.tms_inventory_service.models.responses.TextResponse;
import com.thientdk.tms_inventory_service.repositories.ProductRepository;
import com.thientdk.tms_inventory_service.utils.DataUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public TextResponse createProduct(ProductRequest request) {

        //validate request
        validateCreateProductRequest(request);

        log.info("[createProduct] - Create product START with request {}", request);

        ProductEntity productEntity = ProductEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
        productRepository.save(productEntity);

        log.info("[createProduct] - Create product DONE");
        return new TextResponse("Create product successfully");
    }

    public ProductResponse getProductById(String id) {

        //validate request
        validateProductIdRequest(id);

        log.info("[getProductById] - Get product info START with id: {}", id);
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if (productEntity.isEmpty()) {
            log.info("[getProductById] - Cannot find product ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Cannot find product");
        }

        ProductResponse productResponse = ProductResponse.builder()
                .id(productEntity.get().getId())
                .name(productEntity.get().getId())
                .description(productEntity.get().getDescription())
                .price(productEntity.get().getPrice())
                .stock(productEntity.get().getStock())
                .build();

        log.info("[getProductById] - Get product info DONE");
        return productResponse;
    }

    public TextResponse deleteProductById(String id) {

        //validate request
        validateProductIdRequest(id);

        log.info("[deleteProductById] - Get product info START with id: {}", id);

        if (!productRepository.existsById(id)) {
            log.info("[deleteProductById] - Cannot find product ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Cannot find product!");
        }

        productRepository.deleteById(id);
        log.info("[deleteProductById] - Get product info DONE");
        return new TextResponse("Delete product successfully");
    }

    public Page<ProductEntity> getProductList(Pageable pageable) {

        log.info("[getProductList] - Get product list START");
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);

        log.info("[getProductList] - Get product list DONE");
        return productEntities;
    }


    private void validateCreateProductRequest(ProductRequest request) {

        if (StringUtils.isBlank(request.getName())) {
            log.info("[validateCreateProductRequest] - Name is blank ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Name is invalid!");
        }
        if (StringUtils.isBlank(request.getDescription())) {
            log.info("[validateCreateProductRequest] - Description is blank ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Description is invalid!");
        }
        if (DataUtils.isNull(request.getPrice())) {
            log.info("[validateCreateProductRequest] - Price is blank ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Price is invalid!");
        }
        if (DataUtils.isNull(request.getStock())) {
            log.info("[validateCreateProductRequest] - Stock is blank ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Stock is invalid!");
        }
    }

    private void validateProductIdRequest(String id) {

        if (StringUtils.isBlank(id)) {
            log.info("[validateProductIdRequest] - Product id is blank ERROR");
            throw new ApiException(ErrorCode.BAD_REQUEST, "Product id is invalid!");
        }
    }
}
