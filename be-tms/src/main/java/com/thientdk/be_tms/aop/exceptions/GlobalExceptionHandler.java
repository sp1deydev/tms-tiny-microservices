package com.thientdk.be_tms.aop.exceptions;

import com.thientdk.be_tms.models.responses.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, HttpServletRequest request) {
        ErrorCode errorCode = ex.getErrorCode();
        ErrorResponse response = ErrorResponse.of(errorCode, request.getRequestURI());
        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
        ErrorCode fallback = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorResponse response = ErrorResponse.of(fallback, request.getRequestURI());
        return ResponseEntity.status(fallback.getHttpStatusCode()).body(response);
    }
}
