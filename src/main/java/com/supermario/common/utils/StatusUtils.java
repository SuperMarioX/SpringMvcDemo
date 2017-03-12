package com.supermario.common.utils;

import com.supermario.common.exceptions.CustomizedException;
import org.springframework.http.HttpStatus;

/**
 * Status utils to handle status code
 */

public class StatusUtils {

    public static HttpStatus handleResponseStatus(Exception e) {

        HttpStatus status = null;

        if (e instanceof CustomizedException) {
            switch (((CustomizedException) e).getErrorCode().getCode()) {
                case 2001:
                case 4002:
                    status = HttpStatus.BAD_REQUEST;
                    break;

                case 3001:
                case 3002:
                case 3003:
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                    break;

                case 2002:
                case 4001:
                case 4003:
                    status = HttpStatus.UNAUTHORIZED;
                    break;
            }

        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;

        }

        return status;
    }
}
