package org.api.manapool.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@SerializedName(value = "scryfall_id") private String scryfallId;
	@SerializedName(value = "mtgjson_id") private String mtgJsonId;
	@SerializedName(value = "tcgplayer_id") private Integer tcgplayerId;
	@SerializedName(value = "name") private String name;
	@SerializedName(value = "set") private String set;
	@SerializedName(value = "number") private String number;
	@SerializedName(value = "language_id") private EnumLangages language;
	@SerializedName(value = "condition_id") private EnumCondition condition;
	@SerializedName(value = "finish_id") private EnumFinish finishId;
	
	@Override
	public String toString() {
		return getName() + " " + getSet();
	}
	
	
	public String getScryfallId() {
		return scryfallId;
	}
	public void setScryfallId(String scryfallId) {
		this.scryfallId = scryfallId;
	}
	public String getMtgJsonId() {
		return mtgJsonId;
	}
	public void setMtgJsonId(String mtgJsonId) {
		this.mtgJsonId = mtgJsonId;
	}
	public Integer getTcgplayerId() {
		return tcgplayerId;
	}
	public void setTcgplayerId(Integer tcgplayerId) {
		this.tcgplayerId = tcgplayerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public EnumLangages getLanguage() {
		return language;
	}
	public void setLanguage(EnumLangages language) {
		this.language = language;
	}
	public EnumCondition getCondition() {
		return condition;
	}
	public void setCondition(EnumCondition condition) {
		this.condition = condition;
	}
	public EnumFinish getFinishId() {
		return finishId;
	}
	public void setFinishId(EnumFinish finishId) {
		this.finishId = finishId;
	}
	
	
	
	
}
