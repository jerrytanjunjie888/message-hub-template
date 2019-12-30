package com.decathlon.core.error;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2017-08-23 11:10
 * @Modify:
 **/
public enum  ErrorCode {
    InvalidArgumentException("-40001", "Parameter format error"),
    MissingArgumentException("-20001", "Parameters are missing"),
    SqlErrorException("-50402", "database error！detail info In log system!");

    private String errCode;
    private String errMsg;

    ErrorCode(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
