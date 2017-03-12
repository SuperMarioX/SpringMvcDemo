package com.supermario.common.exceptions;

/**
 * My customized exception and its code
 */

public class CustomizedException extends Exception {

    private ErrorCode errorCode;

    public CustomizedException() {}
    public CustomizedException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * REST
     * 1. bad parameter, empty or not well format
     * 2. init the ssl context error
     * 3. init the httpclient error
     *
     * HTTPCLIENT -> CAS
     * 4. basic code is not rignt, return unauthorized
     * 5. get access_token error, cas server error(internal), or timeout
     * 6. username/pass: server timeout
     *                  username or password not right, unauthorized
     *
     * 7. x-auth-token: not valid, expired, or server timeout, internal error
     *
     *
     */

    public enum ErrorCode {

        // 200
        SUCCEED(1000, "Successfully complete the requests."),

        // 400
        AUTH_BAD_PARAMETER(2001, "Bad parameters found, not acceptable payload."),

        // 401
        AUTH_UNAUTHORIZED(2002, "Authorized error, bad username or password provided."),

        // 500
        HTTP_CLIENT_EMPTY(3001, "Failed to get the httpclient instance."),
        HTTP_CLIENT_ERROR(3002, "Failed to initialize the ssl of httpclient."),
        HTTP_CLIENT_REQUEST_ERROR(3003, "Failed to complete the request to cas server."),

        // 401
        CAS_BASIC_CODE_ERROR(4001, "Authorized error, empty or invalid basic code."),

        // 400
        CAS_ACCESS_TOKEN_GET_ERROR(4002, "Failed to get the access_token."),

        // 401
        CAS_ACCESS_TOKEN_ERROR(4003, "Authorized error, invalid access_token error.");

        private int code;
        private String msg;

        ErrorCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
