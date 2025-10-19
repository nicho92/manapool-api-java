package org.api.manapool.services;

import java.io.IOException;
import java.util.List;

import org.api.manapool.model.EnumCondition;
import org.api.manapool.model.EnumFinish;
import org.api.manapool.model.EnumLangages;
import org.api.manapool.model.InventoryEntry;
import org.api.manapool.model.InventoryItems;
import org.api.manapool.model.ProductQueryEntry;
import org.api.manapool.tools.RestClient;

import com.google.gson.JsonObject;

public class InventoryService {

	private RestClient client;
	
	
	public static void main(String[] args) throws IOException {
		var service = new InventoryService("nicolas.pihen@gmail.com", "mpat_a6uk2b8i9b21m38s2w1a61v8l");
		
		var entry = new  ProductQueryEntry("6cd01460-901c-4d75-bc29-e97ed26afc39",EnumLangages.FR,EnumFinish.NF,EnumCondition.NM,650.50,1);
		
		var ret = service.deleteInventoryItems(entry);
		
		
		System.out.println(ret.getProduct());
		
		
	}
	
	public InventoryService(String email, String token) {
		client = new RestClient(email, token);
	}
	
	public List<InventoryEntry> getSellerInventory() throws IOException
	{
		return client.get("/seller/inventory", null, InventoryItems.class).getInventory();
	}
	
	public List<InventoryEntry> getSellerInventory(int limit, int offset) throws IOException
	{
		return client.get("/seller/inventory?limit="+limit+"&offset="+offset, null, InventoryItems.class).getInventory();
	}

	
	public List<InventoryEntry> addInventoryItems(List<ProductQueryEntry> inventoryList) throws IOException
	{
		return client.post("/seller/inventory/scryfall_id",inventoryList,null,InventoryItems.class).getInventory();
	}
	
	public InventoryEntry updateInventoryItems(ProductQueryEntry item) throws IOException
	{
		var obj = client.put("/seller/inventory/scryfall_id/"+item.getScryfallId()+"?language_id="+item.getLanguage()+"&finish_id="+item.getFinishId()+"&condition_id="+item.getCondition(),item,null,JsonObject.class);
		return client.fromJson(obj.get("inventory").getAsJsonObject().toString(), InventoryEntry.class);
	}
	
	public InventoryEntry deleteInventoryItems(ProductQueryEntry item) throws IOException
	{
		var obj = client.delete("/seller/inventory/scryfall_id/"+item.getScryfallId()+"?language_id="+item.getLanguage()+"&finish_id="+item.getFinishId()+"&condition_id="+item.getCondition(),item,null,JsonObject.class);
		return client.fromJson(obj.get("inventory").getAsJsonObject().toString(), InventoryEntry.class);
		
	}
	
	
}
