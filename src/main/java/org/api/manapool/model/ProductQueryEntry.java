package org.api.manapool.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ProductQueryEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	@SerializedName(value = "scryfall_id") private String scryfallId;
	@SerializedName(value = "language_id") private EnumLangages language;
	@SerializedName(value = "finish_id") private EnumFinish finishId;
	@SerializedName(value = "condition_id") private EnumCondition condition;
	@SerializedName(value = "price_cents") private Integer priceCents;
	private Integer quantity;
	
	
	public ProductQueryEntry() {
		
	}
	
	
	public ProductQueryEntry(Product item , double price, Integer quantity)
	{
		this(item.getScryfallId(), item.getLanguage(), item.getFinishId(), item.getCondition(), price, quantity);
	}
	
	
	public ProductQueryEntry(String scryfallId, EnumLangages language, EnumFinish finishId, EnumCondition condition,double price, Integer quantity) {
		this.scryfallId = scryfallId;
		this.language = language;
		this.finishId = finishId;
		this.condition = condition;
		setPrice(price);
		this.quantity = quantity;
	}

	public String getScryfallId() {
		return scryfallId;
	}
	public void setScryfallId(String scryfallId) {
		this.scryfallId = scryfallId;
	}
	public EnumLangages getLanguage() {
		return language;
	}
	public void setLanguage(EnumLangages language) {
		this.language = language;
	}
	public EnumFinish getFinishId() {
		return finishId;
	}
	public void setFinishId(EnumFinish finishId) {
		this.finishId = finishId;
	}
	public EnumCondition getCondition() {
		return condition;
	}
	public void setCondition(EnumCondition condition) {
		this.condition = condition;
	}
	public Integer getPriceCents() {
		return priceCents;
	}
	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}
	public void setPrice(double d) {
		priceCents = (int)(d*100);
	}
	public double getPrice() {
		return priceCents/100.0;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
