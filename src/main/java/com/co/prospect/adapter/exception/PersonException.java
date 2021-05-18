package com.co.prospect.adapter.exception;

import com.co.prospect.config.excepcion.ErrorCode;

public final class PersonException extends GenericException {
    public PersonException(ErrorCode errorCode) {
        super(errorCode);
    }
}
