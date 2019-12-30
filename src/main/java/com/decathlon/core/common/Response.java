package com.decathlon.core.common;

import java.util.Date;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2017-08-23 11:10
 * @Modify:
 **/
public class Response {

	private String code = "00";
	private boolean success = true;
	private String msg;
	private Object data;

	private Date time = new Date();

	public Response() {
	}

	public Response(String code, String msg, Object data) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public Response(String code, boolean success, String msg, Object data) {
		this.data = data;
		this.code = code;
		this.msg = msg;
		this.success = success;
	}

	public Response(Object data) {
		this.data = data;
	}

	public static Response fail(String code, String message) {
		return new Response(code, false, message, null);
	}

	public static Response fail(String message) {
		return new Response("-1", false, message, null);
	}

	public static Response ok() {
		return new Response();
	}

	public static Response ok(Object data) {
		return new Response("00", true, "success", data);
	}

	public static Response ok(String message, Object data) {
		return new Response("00", true, message, data);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String toString() {
		return "Response{code =" + this.code + ", message =" + this.msg + ", data =" + this.data + ", time = " + this.time + "}";
	}

}
