package org.api.manapool.model;

import java.io.Serializable;

import org.api.manapool.model.enums.EnumLangages;
import org.api.manapool.model.enums.EnumType;

import com.google.gson.annotations.SerializedName;

public class ProductItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private EnumType type;
	private String id;
	@SerializedName(value = "tcgplayer_sku") private Integer tcgplayerSku;
	private Product single;
	private Product sealed;
	
	@Override
	public String toString() {
		return getId();
	}
	
	public boolean isSingle()
	{
		return single!=null;
	}
	
	public boolean isSealed()
	{
		return sealed!=null;
	}
	
	public EnumLangages getLanguage()
	{
		if(isSingle())
			return single.getLanguage();
		else if (isSealed())
			return sealed.getLanguage();
		
		return null;
	}
	
	public String getSet()
	{
		if(isSingle())
			return single.getSet();
		else if (isSealed())
			return sealed.getSet();
		
		return null;
	}
	
	
	public String getName()
	{
		if(isSingle())
			return single.getName();
		else if (isSealed())
			return sealed.getName();
		
		return null;
	}
	
	public Product getSealed() {
		return sealed;
	}
	public void setSealed(Product sealed) {
		this.sealed = sealed;
	}
	public EnumType getType() {
		return type;
	}
	public void setType(EnumType type) {
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
