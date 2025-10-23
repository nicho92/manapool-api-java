package org.api.manapool.model;

import java.io.Serializable;
import java.util.Date;

import org.api.manapool.services.ManaPoolAPIService;

import com.google.gson.annotations.SerializedName;

public class OrderSummary implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	@SerializedName(value = "created_at") private String createdAt;
	private String label;
	@SerializedName(value = "total_cents") private Integer totalCents;
	@SerializedName(value = "shipping_method") private String shippingMethod;
	@SerializedName(value = "latest_fulfillment_status") private String latestStatus;
	
	
	@Override
	public String toString() {
		return getLabel();
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedAtDate() {
		return ManaPoolAPIService.parseDate(getCreatedAt());
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getTotalCents() {
		return totalCents;
	}
	public Double getTotal() {
		return getTotalCents()/100.0;
	}
	
	public void setTotalCents(Integer totalCents) {
		this.totalCents = totalCents;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getLatestStatus() {
		return latestStatus;
	}
	public void setLatestStatus(String latestStatus) {
		this.latestStatus = latestStatus;
	}
	
	
	
}
