package org.api.manapool.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ProductItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String type;
	private String id;
	@SerializedName(value = "tcgplayer_sku") private Integer tcgplayerSku;
	private Product single;
	private Product sealed;
	
	@Override
	public String toString() {
		return getId();
	}
	
	public Product getSealed() {
		return sealed;
	}
	public void setSealed(Product sealed) {
		this.sealed = sealed;
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
	public Integer getTcgplayerSku() {
		return tcgplayerSku;
	}
	public void setTcgplayerSku(Integer tcgplayerSku) {
		this.tcgplayerSku = tcgplayerSku;
	}
	
	public void setSingle(Product single) {
		this.single = single;
	}
	
	public Product getSingle() {
		return single;
	}
	
}
