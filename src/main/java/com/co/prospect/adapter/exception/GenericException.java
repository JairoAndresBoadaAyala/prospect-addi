package com.co.prospect.adapter.exception;

import com.co.prospect.config.excepcion.ErrorCode;

public class GenericException extends RuntimeException {
    private final ErrorCode errorCode;

    public GenericException(ErrorCode errorCode) {
        super(errorCode.getReasonPhrase());
        this.errorCode = errorCode;
    }

    public ErrorCode getCode() {
        return this.errorCode;
    }


}
