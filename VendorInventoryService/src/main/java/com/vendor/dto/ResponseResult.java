package com.vendor.dto;

public class ResponseResult {
	
	private int statucCode;
	private String message;
	private Object data;
	public ResponseResult(int statucCode, String message, Object data) {
		super();
		this.statucCode = statucCode;
		this.message = message;
		this.data = data;
	}
	
	public ResponseResult(int statucCode, String message) {
		super();
		this.statucCode = statucCode;
		this.message = message;
	}

	public int getStatucCode() {
		return statucCode;
	}
	public void setStatucCode(int statucCode) {
		this.statucCode = statucCode;
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
