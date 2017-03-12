package com.supermario.common.response;

import java.io.Serializable;

/**
 * Created by Victor on 11/03/2017.
 */

public class ResponseWrapper implements Serializable {
    private static final long serialVersionUID = -6725781057800655141L;

    private int status;
    private long code;
    private String data;
    private String details;

    public ResponseWrapper() {}

    public ResponseWrapper(long code, String data, String details, int status) {
        this.code = code;
        this.data = data;
        this.details = details;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
