package com.topup.utils;

import static com.topup.utils.TopupApiConstants.AM_CTS_001_MESSAGE;
import static com.topup.utils.TopupApiConstants.AM_CTS_002_MESSAGE;

public final class ResultCode {


    public static final String AM_CTS_001_CODE = "AM_CTS_001";
    public static final String AM_CTS_002_CODE = "AM_CTS_002";


    public static String getResponseMessage(String resultCode) {

        switch (resultCode) {
            case AM_CTS_001_CODE: return AM_CTS_001_MESSAGE;
            case AM_CTS_002_CODE: return AM_CTS_002_MESSAGE;
            default: return "";
        }
    }

}
