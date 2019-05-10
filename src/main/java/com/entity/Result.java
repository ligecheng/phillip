package com.entity;

/**
 * 请求码 
 * 
 * error -- 处理失败
 * success -- 处理成功
 * @author his
 *
 */
public class Result {	
	
	private final String ERROR = "error";
	private final String SUCCESS = "success";
	
	private String requltCode; //请求结果码

	public String getRequltCode() {
		return requltCode;
	}

	public void setRequltCode(String requltCode) {
		this.requltCode = requltCode;
	}

	public Result(String requltCode) {
		super();
		this.requltCode = requltCode;
	}
	public Result() {
		
	}

	public Result setError() {
		requltCode = this.ERROR;
		return this;
	}

	public Result setSuccess() {
		requltCode = this.SUCCESS;
		return this;
	}
	
	

}
