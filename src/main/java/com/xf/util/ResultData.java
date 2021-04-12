package com.xf.util;

import java.io.Serializable;
import java.util.List;

public class ResultData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7414901536083155418L;

	/**
	 * 默认值0
	 */
	private int state;
	
	/**
	 *  默认值null
	 */
	private String message;
	
	/**
	 * 默认值0L
	 */
	private long total;

	/**
	 * 默认值null
	 */
	private List<?> rows;

	/**
	 * 默认值null
	 */
	private Object obj;
	
	public ResultData() {
		
	}
	
	public ResultData(int state) {
		this.state = state;
	}
	
	public ResultData(Object obj) {
		this.obj = obj;
	}
	
	public ResultData(List<?> rows) {
		this.rows = rows;
	}

	public ResultData(List<?> rows,long total) {
		this.rows = rows;
		this.total = total;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
