package com.zhuyin.gxj.entity;


public class ResultBean {

	int errCode=0;
	
	String errMsg="OK";
	
	private String userToken="";

	
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "ResultBean [errCode=" + errCode + ", errMsg=" + errMsg
				+ ", userToken=" + userToken + "]";
	}

	
}
