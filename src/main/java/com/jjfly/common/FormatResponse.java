package com.jjfly.common;

import org.springframework.ui.ModelMap;

/**
 * Created by luwin on 16-5-26.
 */
public class FormatResponse {
    private int statusCode;
    private String statusInfo;
    private Object data;

    public FormatResponse(int statusCode, String statusInfo, Object data) {
        this.statusCode = statusCode;
        this.statusInfo = statusInfo;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(ModelMap data) {
        this.data = data;
    }
}
