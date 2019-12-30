package com.decathlon.core.exception;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2017-08-23 11:10
 * @Modify:
 **/
public class CustomException extends RuntimeException{

    private String code;
    private String reason;

    public CustomException(String code){
        super(code, null);
        this.code = code;
    }

    public CustomException(String code, String reason) {
        super(code);
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
