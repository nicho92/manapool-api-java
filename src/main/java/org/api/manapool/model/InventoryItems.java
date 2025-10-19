package org.api.manapool.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class InventoryItems implements Serializable, Iterable<InventoryEntry>{

	private static final long serialVersionUID = 1L;

	
	private List<InventoryEntry> inventory;
	

	@Override
	public Iterator<InventoryEntry> iterator() {
		return getInventory().iterator();
	}


	public List<InventoryEntry> getInventory() {
		return inventory;
	}


	public void setInventory(List<InventoryEntry> inventory) {
		this.inventory = inventory;
	}
	
	
}
