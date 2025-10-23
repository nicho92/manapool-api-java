import java.io.IOException;

import org.api.manapool.model.ProductQueryEntry;
import org.api.manapool.services.ManaPoolAPIService;

public class Testers {

	public static void main(String[] args) throws IOException {
		String email="";
		String token="";
		
		
		
		var service = new ManaPoolAPIService(email, token);
		
	
		
		
		//  DELETE TEST
		
		service.getSellerInventory().forEach(item->{
			try {
				service.deleteInventoryItems(new ProductQueryEntry(item.getProduct().getSingle(), 0, null));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}

}
