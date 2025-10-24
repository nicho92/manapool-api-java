package org.api.manapool.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SerializedName(value = "subtotal_cents") private int subTotalCents;
	@SerializedName(value = "shipping_cents") private int shippingCents;
	@SerializedName(value = "total_cents") private int totalCents;
	@SerializedName(value = "fee_cents") private int feeCents;
	@SerializedName(value = "net_cents") private int netCents;
	
	
	
	public int getSubTotalCents() {
		return subTotalCents;
	}
	
	public double getSubTotal()
	{
		return subTotalCents/100.0;
	}
	
	public void setSubTotalCents(int subTotalCents) {
		this.subTotalCents = subTotalCents;
	}
	public int getShippingCents() {
		return shippingCents;
	}
	public double getShipping() {
		return shippingCents/100.0;
	}
	
	public void setShippingCents(int shippingCents) {
		this.shippingCents = shippingCents;
	}
	public int getTotalCents() {
		return totalCents;
	}
	public double getTotal() {
		return totalCents/100.0;
	}
	public void setTotalCents(int totalCents) {
		this.totalCents = totalCents;
	}
	public int getFeeCents() {
		return feeCents;
	}
	public double getFee() {
		return feeCents/100.0;
	}
	public void setFeeCents(int feeCents) {
		this.feeCents = feeCents;
	}
	public int getNetCents() {
		return netCents;
	}
	public double getNet() {
		return netCents/100.0;
	}
	public void setNetCents(int netCents) {
		this.netCents = netCents;
	}
	
	
	
	
	
}
