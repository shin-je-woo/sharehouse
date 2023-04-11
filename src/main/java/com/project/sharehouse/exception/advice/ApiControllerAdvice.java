package com.project.sharehouse.exception.advice;

import com.project.sharehouse.exception.BizException;
import com.project.sharehouse.exception.ErrorCode;
import com.project.sharehouse.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMehtodValidationExceptions(MethodArgumentNotValidException e) {
        List<ErrorResponse.ErrorDetail> errorDetails = makeFieldErrorDetails(e.getBindingResult());
        ErrorResponse errorResponse = makeErrorResponse(ErrorCode.INPUT_VALUE_INVALID, errorDetails);
        return ResponseEntity.ok()
                .body(errorResponse);
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ErrorResponse> handleBizException(BizException e) {
        ErrorResponse.ErrorDetail errorDetail = makeGlobalErrorDetails(e);
        List<ErrorResponse.ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(errorDetail);
        ErrorResponse errorResponse = makeErrorResponse(e.getErrorCode(), errorDetails);
        return ResponseEntity.ok()
                .body(errorResponse);
    }

    private ErrorResponse.ErrorDetail makeGlobalErrorDetails(Exception e) {
        return ErrorResponse.ErrorDetail.builder()
                .field("globalError")
                .reason(e.getMessage())
                .build();
    }


    private List<ErrorResponse.ErrorDetail> makeFieldErrorDetails(BindingResult bindingResult) {
         return bindingResult.getFieldErrors().parallelStream()
                .map(error -> ErrorResponse.ErrorDetail.builder()
                        .field(error.getField())
                        .value(error.getRejectedValue())
                        .reason(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode, List<ErrorResponse.ErrorDetail> errorDetails) {
        if (errorCode == null) {
            errorCode = ErrorCode.GLOVAL_ERROR;
        }
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus())
                .details(errorDetails)
                .build();
    }
}
