package com.zhuyin.gxj.entity;


public class ActionResultBean {

	private int err_code=0;
	
	private String err_msg="OK";

	private long timestamp;

	public int getErr_code() {
		return err_code;
	}

	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "ActionResultBean{" +
				"err_code=" + err_code +
				", err_msg='" + err_msg + '\'' +
				", timestamp=" + timestamp +
				'}';
	}
}
