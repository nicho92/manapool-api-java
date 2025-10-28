package org.api.manapool.tests;

import java.io.File;
import java.io.IOException;

import org.api.manapool.model.enums.EnumType;
import org.api.manapool.services.ManaPoolAPIService;

public class Testers {

	public static void main(String[] args) throws IOException {
		var service = new ManaPoolAPIService(new File(System.getProperty("user.home")+"/manapool.properties"));
		
		
//		service.getSellerInventory().getItems().forEach(i->{
//			System.out.println(i.getProduct().getName() + " " + i.getProduct().getSet() + " " + " " + i.getProduct().getLanguage() +" " + i.getPriceValue() + " " + i.getProductId());
//		});
		
		System.out.println(service.getSellerInventoryById(EnumType.SINGLE, "df9ec379-bcef-4607-a6e4-aa194e09bc73").getProduct().getName());
		
		
	}

}
