package org.api.manapool.model;

import java.io.Serializable;
import java.util.Date;

import org.api.manapool.services.ManaPoolAPIService;

import com.google.gson.annotations.SerializedName;

public class FulFillments implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	@SerializedName(value = "tracking_company") private String trackingCompany; 
	@SerializedName(value = "tracking_number") private String trackingNumber;
	@SerializedName(value = "tracking_url") private String trackingUrl; 
	@SerializedName(value = "in_transit_at") private String inTransitAt;
	@SerializedName(value = "estimated_delivery_at") private String estimatedDeliveryAt;
	@SerializedName(value = "delivered_at") private String deliveredAt;
	
	
	@Override
	public String toString() {
		return getStatus();
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrackingCompany() {
		return trackingCompany;
	}
	public void setTrackingCompany(String trackingCompany) {
		this.trackingCompany = trackingCompany;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getTrackingUrl() {
		return trackingUrl;
	}
	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}
	public String getInTransitAt() {
		return inTransitAt;
	}
	public Date getInTransitDate() {
			return ManaPoolAPIService.parseDate(getInTransitAt());
	}
	public void setInTransitAt(String inTransitAt) {
		this.inTransitAt = inTransitAt;
	}
	public String getEstimatedDeliveryAt() {
		return estimatedDeliveryAt;
	}
	public Date getEstimatedDeliveryDate() {
		return ManaPoolAPIService.parseDate(getEstimatedDeliveryAt());
	}
	public void setEstimatedDeliveryAt(String estimatedDeliveryAt) {
		this.estimatedDeliveryAt = estimatedDeliveryAt;
	}
	public String getDeliveredAt() {
		return deliveredAt;
	}
	public Date getDeliveredDate() {
		return ManaPoolAPIService.parseDate(getDeliveredAt());
	}
	public void setDeliveredAt(String deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
	
	
	
}
