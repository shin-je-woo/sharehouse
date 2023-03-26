package com.project.sharehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    GLOVAL_ERROR("code000", "글로벌 오류입니다.", 400),
    INPUT_VALUE_INVALID("code001", "입력값이 올바르지 않습니다.", 400),
    EXIST_DUPL_VALUE("code002", "중복 데이터가 존재합니다.", 400);

    private final String code;
    private final String message;
    private final int status;
}