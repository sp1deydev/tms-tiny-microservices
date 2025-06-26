package com.thientdk.tms_inventory_service.models.responses;

import com.thientdk.tms_inventory_service.aop.exceptions.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int code;
    private String message;
    private boolean success;
    private String error;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, int code, String message, boolean success, String error, String path) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.success = success;
        this.error = error;
        this.path = path;
    }

    public static ErrorResponse of(ErrorCode errorCode, String path) {
        return new ErrorResponse(
                LocalDateTime.now(),
                errorCode.getCode(),
                errorCode.getMessage(),
                errorCode.isSuccess(),
                errorCode.name(),
                path
        );
    }
}
