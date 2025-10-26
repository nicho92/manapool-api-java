package org.api.manapool.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private String name;
	@SerializedName(value = "set_code") private String setCode;
	@SerializedName(value = "set_name") private String setName;
	@SerializedName(value = "card_number") private String cardNumber;
	private String rarity;
	@SerializedName(value = "from_price_cents") private Integer fromPriceCents;
	@SerializedName(value = "quantity_available") private Integer quantityAvailable;
	@SerializedName(value = "release_date") private String releaseDate;
	@SerializedName(value = "legal_formats") private List<String> formats;
	@SerializedName(value = "flavor_name") private String flavorName;
	private String layout;
	@SerializedName(value = "is_token") private boolean token;
	@SerializedName(value = "promo_types") private List<String> promoTypes;
	private List<String> finishes;
	private String text;
	@SerializedName(value = "color_identity") private List<String> colorIdentity;
	private Double edhrecSaltiness;
	private String power;
	private String defense;
	@SerializedName(value = "mana_cost") private String manaCost;
	@SerializedName(value = "mana_value") private Integer manaValue;
	
	
	
	@Override
	public String toString() {
		return getName();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSetCode() {
		return setCode;
	}
	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public Integer getFromPriceCents() {
		return fromPriceCents;
	}
	public void setFromPriceCents(Integer fromPriceCents) {
		this.fromPriceCents = fromPriceCents;
	}
	public Integer getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<String> getFormats() {
		return formats;
	}
	public void setFormats(List<String> formats) {
		this.formats = formats;
	}
	public String getFlavorName() {
		return flavorName;
	}
	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public boolean isToken() {
		return token;
	}
	public void setToken(boolean token) {
		this.token = token;
	}
	public List<String> getPromoTypes() {
		return promoTypes;
	}
	public void setPromoTypes(List<String> promoTypes) {
		this.promoTypes = promoTypes;
	}
	public List<String> getFinishes() {
		return finishes;
	}
	public void setFinishes(List<String> finishes) {
		this.finishes = finishes;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getColorIdentity() {
		return colorIdentity;
	}
	public void setColorIdentity(List<String> colorIdentity) {
		this.colorIdentity = colorIdentity;
	}
	public Double getEdhrecSaltiness() {
		return edhrecSaltiness;
	}
	public void setEdhrecSaltiness(Double edhrecSaltiness) {
		this.edhrecSaltiness = edhrecSaltiness;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getDefense() {
		return defense;
	}
	public void setDefense(String defense) {
		this.defense = defense;
	}
	public String getManaCost() {
		return manaCost;
	}
	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}
	public Integer getManaValue() {
		return manaValue;
	}
	public void setManaValue(Integer manaValue) {
		this.manaValue = manaValue;
	}
	
	
	
}
