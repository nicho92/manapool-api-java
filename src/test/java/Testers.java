import java.io.IOException;

import org.api.manapool.services.ManaPoolAPIService;

public class Testers {

	public static void main(String[] args) throws IOException {
		String email="";
		String token="";
		
		
		
		var service = new ManaPoolAPIService(email, token);
		
		service.getSellerInventory().forEach(e->{
			
			System.out.println(e.getProduct() + " " +  e.getPriceValue());
						
		});
		
		
	}

}
