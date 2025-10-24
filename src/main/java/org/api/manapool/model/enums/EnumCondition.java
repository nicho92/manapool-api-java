package org.api.manapool.model.enums;

public enum EnumCondition {

	NM ("Near Mint"), 
	LP ("Lightly Played"), 
	MP("Moderatly Played"),
	HP("Heavily Played"),
	DMG("Damaged");
	
	
	private String label;
	
	EnumCondition(String label) {
		this.label=label;
	}
	
	public String getLabel() {
		return label;
	}
	
	
}
