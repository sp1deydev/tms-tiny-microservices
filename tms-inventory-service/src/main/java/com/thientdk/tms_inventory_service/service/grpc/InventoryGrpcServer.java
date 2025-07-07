package com.thientdk.tms_inventory_service.service.grpc;

import com.thientdk.tms_inventory_service.aop.exceptions.ApiException;
import com.thientdk.tms_inventory_service.grpc.InventoryServiceGrpc;
import com.thientdk.tms_inventory_service.grpc.ProductRequestGrpc;
import com.thientdk.tms_inventory_service.grpc.TextResponseGrpc;
import com.thientdk.tms_inventory_service.mappers.gprc.ProductGrpcMapper;
import com.thientdk.tms_inventory_service.models.requests.ProductRequest;
import com.thientdk.tms_inventory_service.models.responses.TextResponse;
import com.thientdk.tms_inventory_service.service.ProductService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class InventoryGrpcServer extends InventoryServiceGrpc.InventoryServiceImplBase {

    private final ProductService productService;

    @Override
    public void createProduct(ProductRequestGrpc request, StreamObserver<TextResponseGrpc> responseObserver) {
        try {
            log.info("[createProduct] - GRPC create product START {}", request);
            ProductRequest productRequest = ProductGrpcMapper.fromGrpcToProductRequest(request);

            TextResponse response = productService.createProduct(productRequest);

            TextResponseGrpc grpcResponse = TextResponseGrpc.newBuilder()
                    .setMessage(response.getMessage())
                    .build();

            log.info("[createProduct] - GRPC create product DONE");
            responseObserver.onNext(grpcResponse);
            responseObserver.onCompleted();

        } catch (ApiException e) {
            log.error("[createProduct] - GRPC create product business error ERROR {}", e.getExceptionMessage());
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription(e.getExceptionMessage())
                    .asRuntimeException());
        } catch (Exception e) {
            log.error("[createProduct] - GRPC create product system error ERROR", e);
            responseObserver.onError(Status.INTERNAL
                    .withDescription("You got system error when call tms-inventory-service")
                    .asRuntimeException());
        }
    }
}
