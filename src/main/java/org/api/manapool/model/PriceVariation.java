package org.api.manapool.model;

import java.io.Serializable;

import org.api.manapool.model.enums.EnumCondition;
import org.api.manapool.model.enums.EnumFinish;
import org.api.manapool.model.enums.EnumLangages;

import com.google.gson.annotations.SerializedName;

public class PriceVariation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String name;
	private String number;
	private String url;
	
	
	@SerializedName(value = "product_id") private String productId;
	@SerializedName(value = "product_type") private String productType;
	@SerializedName(value = "condition_id") private EnumCondition conditionId;
	@SerializedName(value = "finish_id") private EnumFinish finishId;
	@SerializedName(value = "language_id") private EnumLangages languageId;
	
	
	@SerializedName(value = "set_code") private String setCode;
	@SerializedName(value = "multiverse_id") private String multiverseId;
	@SerializedName(value = "scryfall_id") private String scryfallId;
	@SerializedName(value = "available_quantity") private int available;
	@SerializedName(value = "price_cents", alternate = "low_price") private int priceCents;
	@SerializedName(value = "price_cents_lp_plus") private int priceCentslpPlus;
	@SerializedName(value = "price_cents_foil") private int priceCentsFoil;
	@SerializedName(value = "price_cents_lp_plus_foil") private int priceCentslpPlusFoil;
	@SerializedName(value = "price_cents_nm_foil") private int priceCentsNmPlus;
	@SerializedName(value = "price_cents_etched") private int priceCentsEtched;
	@SerializedName(value = "price_cents_lp_plus_etched") private int priceCentsLpPlusEtched;
	@SerializedName(value = "price_cents_nm_etched") private int priceCentslpEtched;
	
	
	@Override
	public String toString() {
		return getName();
	}
	
	
	public EnumCondition getConditionId() {
		return conditionId;
	}


	public void setConditionId(EnumCondition conditionId) {
		this.conditionId = conditionId;
	}


	public EnumFinish getFinishId() {
		return finishId;
	}


	public void setFinishId(EnumFinish finishId) {
		this.finishId = finishId;
	}


	public EnumLangages getLanguageId() {
		return languageId;
	}


	public void setLanguageId(EnumLangages languageId) {
		this.languageId = languageId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSetCode() {
		return setCode;
	}
	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}
	public String getMultiverseId() {
		return multiverseId;
	}
	public void setMultiverseId(String multiverseId) {
		this.multiverseId = multiverseId;
	}
	public String getScryfallId() {
		return scryfallId;
	}
	public void setScryfallId(String scryfallId) {
		this.scryfallId = scryfallId;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getPriceCents() {
		return priceCents;
	}
	public void setPriceCents(int priceCents) {
		this.priceCents = priceCents;
	}
	public int getPriceCentslpPlus() {
		return priceCentslpPlus;
	}
	public void setPriceCentslpPlus(int priceCentslpPlus) {
		this.priceCentslpPlus = priceCentslpPlus;
	}
	public int getPriceCentsFoil() {
		return priceCentsFoil;
	}
	public void setPriceCentsFoil(int priceCentsFoil) {
		this.priceCentsFoil = priceCentsFoil;
	}
	public int getPriceCentslpPlusFoil() {
		return priceCentslpPlusFoil;
	}
	public void setPriceCentslpPlusFoil(int priceCentslpPlusFoil) {
		this.priceCentslpPlusFoil = priceCentslpPlusFoil;
	}
	public int getPriceCentsNmPlus() {
		return priceCentsNmPlus;
	}
	public void setPriceCentsNmPlus(int priceCentsNmPlus) {
		this.priceCentsNmPlus = priceCentsNmPlus;
	}
	public int getPriceCentsEtched() {
		return priceCentsEtched;
	}
	public void setPriceCentsEtched(int priceCentsEtched) {
		this.priceCentsEtched = priceCentsEtched;
	}
	public int getPriceCentsLpPlusEtched() {
		return priceCentsLpPlusEtched;
	}
	public void setPriceCentsLpPlusEtched(int priceCentsLpPlusEtched) {
		this.priceCentsLpPlusEtched = priceCentsLpPlusEtched;
	}
	public int getPriceCentslpEtched() {
		return priceCentslpEtched;
	}
	public void setPriceCentslpEtched(int priceCentslpEtched) {
		this.priceCentslpEtched = priceCentslpEtched;
	}
	
	
	
	
}
