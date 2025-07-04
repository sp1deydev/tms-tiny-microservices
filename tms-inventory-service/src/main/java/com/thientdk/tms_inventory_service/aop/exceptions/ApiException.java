package com.thientdk.tms_inventory_service.aop.exceptions;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private ErrorCode errorCode;
    private String exceptionMessage;

    public ApiException(ErrorCode errorCode, String resourceName) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.exceptionMessage = exceptionMessage;
    }

    public ApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return errorCode.getMessage(exceptionMessage);
    }
}
