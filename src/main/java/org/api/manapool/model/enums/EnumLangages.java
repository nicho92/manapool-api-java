package org.api.manapool.model.enums;

public enum EnumLangages {
	EN("English"), 
	JA("Japanese"), 
	FR("French"), 
	IT("Italian"), 
	DE("German"), 
	ES("Spanish"), 
	AR("Arabic"), 
	CS ("Chinese Simplified"), 
	CT("Chinese Traditional"), 
	EL("Ancient Greek"), 
	HE("Hebrew"), 
	KO("Korean"), 
	LA("Latin"), 
	PH("Phyrexian"), 
	PT("Portuguese (Brazil)"), 
	RU("Russian"), 
	SA("Sanskrit");
	
	private String label;
	
	
	EnumLangages(String label) {
		this.label=label;
	}
	
	
	public String getLabel() {
		return label;
	}
	
}
