package com.project.sharehouse.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private final boolean fail = true;

    private String code;
    private String message;
    private int status;
    private List<ErrorDetail> details;

    @Builder
    public ErrorResponse(String code, String message, int status, List<ErrorDetail> details) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.details = details;
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ErrorDetail {

        private String field;
        private String value;
        private String reason;

        @Builder
        public ErrorDetail(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

    }
}