package org.api.manapool.services;

import java.io.IOException;
import java.util.List;

import org.api.manapool.model.InventoryEntry;
import org.api.manapool.model.InventoryItems;
import org.api.manapool.model.ProductQueryEntry;
import org.api.manapool.tools.RestClient;

import com.google.gson.JsonObject;

public class InventoryService {

	private RestClient client;
	
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
