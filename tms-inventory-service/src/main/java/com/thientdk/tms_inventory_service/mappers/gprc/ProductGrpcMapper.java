package com.thientdk.tms_inventory_service.mappers.gprc;

import com.thientdk.tms_inventory_service.grpc.ProductRequestGrpc;
import com.thientdk.tms_inventory_service.models.requests.ProductRequest;
import com.thientdk.tms_inventory_service.utils.DataUtils;

public class ProductGrpcMapper {

    public static ProductRequest fromGrpcToProductRequest(ProductRequestGrpc request) {
        return ProductRequest.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(DataUtils.toBigDecimal(request.getPrice()))
                .stock(DataUtils.safeToInteger(request.getStock()))
                .build();
    }
}
