package com.thientdk.be_tms.mappers.grpc;

import com.thientdk.be_tms.models.requests.ProductRequest;
import com.thientdk.be_tms.models.responses.ProductResponse;
import com.thientdk.be_tms.utils.DataUtils;
import com.thientdk.tms_inventory_service.grpc.ProductRequestGrpc;
import com.thientdk.tms_inventory_service.grpc.ProductResponseGrpc;

public class ProductGrpcMapper {

    public static ProductRequestGrpc toProductRequestGrpc(ProductRequest request) {
        return ProductRequestGrpc.newBuilder()
                .setName(DataUtils.safeToString(request.getName()))
                .setDescription(DataUtils.safeToString(request.getDescription()))
                .setPrice(DataUtils.safeToString(request.getPrice()))
                .setStock(DataUtils.safeToInteger(request.getStock()))
                .build();
    }

    public static ProductResponse fromGrpcToProductResponse(ProductResponseGrpc response) {
        return ProductResponse.builder()
                .name(response.getName())
                .description(response.getDescription())
                .price(DataUtils.toBigDecimal(response.getPrice()))
                .stock(response.getStock())
                .build();
    }
}
