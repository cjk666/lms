package com.entor.entity;

public class Result {
	
	/**
	 *	状态0成功 1失败 
	 */
	private int statue;
	
	private String msg;
	
	public Result() {
	}
	
	public Result(int statue, String msg) {
		this.statue = statue;
		this.msg = msg;
	}

	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
