package org.api.manapool.tests;

import java.io.File;
import java.io.IOException;

import org.api.manapool.services.ManaPoolAPIService;

public class Testers {

	public static void main(String[] args) throws IOException {
		var service = new ManaPoolAPIService(new File(System.getProperty("user.home")+"/manapool.properties"));
		
		
		service.getSellerInventory().getItems().forEach(i->{
			
			System.out.println(i.getProduct().getName() + " " + i.getProduct().getSet() + " " + " " + i.getProduct().getLanguage() +" " + i.getPriceValue());
			
		});
		
	}

}
