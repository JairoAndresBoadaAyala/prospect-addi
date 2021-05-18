package com.co.prospect.config.excepcion;

public enum ErrorCode {

    NOT_FOUND_EXTERNAL( "Not found system external"),
    NOT_FOUNT_DB( "Not found system internal"),
    JUDICIAL_RECORD_ERROR( "Has a judicial past");

    private final String reasonPhrase;

    ErrorCode(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }


    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

}
