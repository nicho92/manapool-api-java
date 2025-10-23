package org.api.manapool.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Serializable, Iterable<InventoryItem>{

	private static final long serialVersionUID = 1L;

	
	private List<InventoryItem> inventory;
	

	@Override
	public Iterator<InventoryItem> iterator() {
		return getInventory().iterator();
	}


	public List<InventoryItem> getInventory() {
		return inventory;
	}


	public void setInventory(List<InventoryItem> inventory) {
		this.inventory = inventory;
	}
	
	
}
