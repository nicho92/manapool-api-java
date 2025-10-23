package org.api.manapool.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Serializable, Iterable<InventoryItem>{

	private static final long serialVersionUID = 1L;

	
	private List<InventoryItem> items;
	

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
