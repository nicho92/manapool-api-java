package org.api.manapool.model;

import java.io.Serializable;
import java.util.Date;

import org.api.manapool.services.ManaPoolAPIService;

import com.google.gson.annotations.SerializedName;

public class InventoryItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	@SerializedName(value = "price_cents") private Integer priceCents;
	private Integer quantity;
	@SerializedName(value = "effective_as_of") private String effectiveAsOf;
	@SerializedName(value = "product_type") private String type;
	@SerializedName(value = "product_id") private String productId;
	private ProductItem product;
	
	
	
	public double getPriceValue()
	{
		return getPriceCents()/100.0;
	}
	
	
	
	public Date getDateffectiveAsOf() {
		return ManaPoolAPIService.parseDate(effectiveAsOf);
	}
	
	
	@Override
	public String toString() {
		return getId();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPriceCents() {
		return priceCents;
	}
	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getEffectiveAsOf() {
		return effectiveAsOf;
	}
	public void setEffectiveAsOf(String effectiveAsOf) {
		this.effectiveAsOf = effectiveAsOf;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public ProductItem getProduct() {
		return product;
	}


	public void setProduct(ProductItem product) {
		this.product = product;
	}
	
	
	
	
}
