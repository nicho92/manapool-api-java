package org.api.manapool.model;

import java.io.Serializable;

public class Pagination implements Serializable{

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	private static final long serialVersionUID = 1L;
	
	
	 private int total;
	 private int returned;
	 private int offset;
	 private int limit;
	 
	 
	 

}
