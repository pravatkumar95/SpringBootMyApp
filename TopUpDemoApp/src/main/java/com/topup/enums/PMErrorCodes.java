package com.topup.enums;

import org.springframework.http.HttpStatus;

public enum PMErrorCodes implements ResponseCode {

    AM_CTS_001(HttpStatus.OK),
    AM_CTS_002(HttpStatus.OK);
    private final HttpStatus httpStatus;

    /**
     * Instantiates a new response codes.
     * @param httpStatus the http status
     */
    PMErrorCodes(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String value() {
        return name();
    }

}
