package com.topup.utils;


import com.topup.enums.PMErrorCodes;
import com.topup.model.ExceptionParams;
import com.topup.model.Meta;
import lombok.extern.slf4j.Slf4j;

import static com.topup.utils.Constants.*;


@Slf4j
public class Util {
    private Util() { }


    /**
     * Gets fail meta.
     *
     * @param code    the code
     * @param message the message
     *
     * @return the fail meta
     */
    public static Meta getFailMeta(String code, String message) {
        return new Meta(FAIL, message, PMErrorCodes.valueOf(code).getStatus().getReasonPhrase());
    }

    /**
     * Gets success meta.
     *
     * @param code    the code
     * @param message the message
     *
     * @return the success meta
     */
    public static Meta getSuccessMeta(String code, String message) {
        return new Meta(SUCCESS, message, PMErrorCodes.valueOf(code).getStatus().getReasonPhrase());
    }

    /**
     * Gets time out.
     *
     * @param params the message
     *
     * @return the time out
     */
    public static Meta getTimeOut(ExceptionParams params) {
        return new Meta( params.getCode().getStatus().getReasonPhrase(),
                         TIMEOUT, params.getDescription());
    }




}
