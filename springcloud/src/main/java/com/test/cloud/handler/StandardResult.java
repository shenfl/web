package com.test.cloud.handler;

import java.io.Serializable;

/**
 * @author shenfl
 */
public class StandardResult implements Serializable {

    private boolean success;
    private int code;
    private String message;
    private Object data;

    public StandardResult(boolean success, int code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static StandardResult succeeded(Object data){
        return new StandardResult(true,10000,"",data);
    }

    public static StandardResult failed(int code, String message) {
        return new StandardResult(false, code, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}