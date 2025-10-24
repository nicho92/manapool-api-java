package org.api.manapool.model.enums;

public enum EnumFinish {
	NF ("Non-Foil"),
	FO("Foil"),
	EF("Etched Foil");
	
	
	private String label;

	EnumFinish(String label)
	{
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
