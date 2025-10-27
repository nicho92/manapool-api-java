package org.api.manapool.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Inventory implements Serializable, Iterable<InventoryItem>{

	private static final long serialVersionUID = 1L;

	
	@SerializedName(value = "inventory") private List<InventoryItem> items;
	
	private Pagination pagination;
	
	
	public Pagination getPagination() {
		return pagination;
	}

	@Override
	public Iterator<InventoryItem> iterator() {
		return getItems().iterator();
	}


	public List<InventoryItem> getItems() {
		return items;
	}


	public void setItems(List<InventoryItem> inventory) {
		this.items = inventory;
	}
	
	
}
