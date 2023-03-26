package com.project.sharehouse.exception;

public class DuplUserException extends BizException {

    public DuplUserException(String message) {
        super("이미 존재하는 회원입니다. 중복필드 = " + message);
    }

}
