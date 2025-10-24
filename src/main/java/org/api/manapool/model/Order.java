package org.api.manapool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.api.manapool.services.ManaPoolAPIService;

import com.google.gson.annotations.SerializedName;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	@SerializedName(value = "created_at") private String createdAt;
	private String label;
	@SerializedName(value = "total_cents") private int totalCents;
	@SerializedName(value = "shipping_method") private String shippingMethod;
	@SerializedName(value = "latest_fulfillment_status") private String latestFulfillmentStatus;
	@SerializedName(value = "buyer_id") private String buyerId; 
	@SerializedName(value = "shipping_address") private Address shippingAddress;
	private Payment payment;
	private FulFillments fulfillments;
	private List<ProductItem> items;
	
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
	public String getCreatedAt() {
		return createdAt;
	}
	public Date getCreatedAtDate() {
		return ManaPoolAPIService.parseDate(getCreatedAt());
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
	public int getTotalCents() {
		return totalCents;
	}
	public void setTotalCents(int totalCents) {
		this.totalCents = totalCents;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getLatestFulfillmentStatus() {
		return latestFulfillmentStatus;
	}
	public void setLatestFulfillmentStatus(String latestFulfillmentStatus) {
		this.latestFulfillmentStatus = latestFulfillmentStatus;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public FulFillments getFulfillments() {
		return fulfillments;
	}
	public void setFulfillments(FulFillments fulfillments) {
		this.fulfillments = fulfillments;
	}
	public List<ProductItem> getItems() {
		return items;
	}
	public void setItems(List<ProductItem> items) {
		this.items = items;
	}
	
}
