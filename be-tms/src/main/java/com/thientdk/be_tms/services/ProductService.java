package com.thientdk.be_tms.services;

import com.thientdk.be_tms.mappers.grpc.ProductGrpcMapper;
import com.thientdk.be_tms.models.requests.ProductRequest;
import com.thientdk.be_tms.models.responses.TextResponse;
import com.thientdk.tms_inventory_service.grpc.InventoryServiceGrpc;
import com.thientdk.tms_inventory_service.grpc.ProductRequestGrpc;
import com.thientdk.tms_inventory_service.grpc.TextResponseGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @GrpcClient("inventory-service")
    private InventoryServiceGrpc.InventoryServiceBlockingStub inventoryServiceBlockingStub;

    public TextResponse createProduct(ProductRequest request) {

        log.info("[createProduct] - create product START with request: {}", request);
        ProductRequestGrpc productRequestGrpc = ProductGrpcMapper.toProductRequestGrpc(request);

        TextResponseGrpc textResponseGrpc = inventoryServiceBlockingStub.createProduct(productRequestGrpc);

        log.info("[createProduct] - create product DONE");
        return new TextResponse(textResponseGrpc.getMessage());
    }

}
