package org.api.manapool.services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.manapool.model.Account;
import org.api.manapool.model.Card;
import org.api.manapool.model.Inventory;
import org.api.manapool.model.InventoryItem;
import org.api.manapool.model.Order;
import org.api.manapool.model.OrderSummary;
import org.api.manapool.model.PriceVariation;
import org.api.manapool.model.Product;
import org.api.manapool.model.ProductQueryEntry;
import org.api.manapool.model.enums.EnumType;
import org.api.manapool.tools.ManaPoolConstants;
import org.api.manapool.tools.RestClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ManaPoolAPIService {

	private RestClient client;
	protected static Logger logger = LogManager.getLogger(ManaPoolAPIService.class);
	
	public ManaPoolAPIService(String email, String token) {
		client = new RestClient(email, token);
	}

	public ManaPoolAPIService(File f) throws IOException {
		
		var p = new Properties();
		try(var read = new FileReader(f))
		{
			p.load(read);
			client = new RestClient(p.getProperty("EMAIL"), p.getProperty("TOKEN"));	
		}
	}
	
	
	
	public RestClient getClient() {
		return client;
	}
	
	public Card cardInfo(String cardName) throws IOException
	{
		try {
			return cardInfo(List.of(cardName)).getFirst();
		}catch(NoSuchElementException e)
		{
			logger.error("No results found for {}",cardName,e);
			return null;
		}
	}
	
	
	public List<Card> cardInfo(List<String> cardNames) throws IOException
	{
		var obj = new JsonObject();
		var arr = new JsonArray();
		obj.add("card_names", arr);
		cardNames.forEach(arr::add);
		var ret = client.post("/card_info",obj,null,JsonObject.class).get("cards").getAsJsonArray();
		return ret.asList().stream().map(e->client.fromJson(e.toString(),Card.class)).toList();
	}
	
	public Inventory getSellerInventory() throws IOException
	{
		var inventory = client.get("/seller/inventory", null, Inventory.class);
		return getSellerInventory(inventory.getPagination().getTotal(),0);
	}
	
	public Inventory getSellerInventory(int limit, int offset) throws IOException
	{
		return client.get("/seller/inventory?limit="+limit+"&offset="+offset, null, Inventory.class);
	}
	
	public InventoryItem getSellerInventoryById(EnumType type, String id) throws IOException
	{
		var obj = client.get("/seller/inventory/product/mtg_"+type.name().toLowerCase()+"/"+id, null, JsonObject.class).get("inventory").getAsJsonObject();
		
		return client.fromJson(obj.toString(), InventoryItem.class);

	}
	
	
	public Inventory addInventoryItems(List<ProductQueryEntry> inventoryList) throws IOException
	{
		return client.post("/seller/inventory/scryfall_id",inventoryList,null,Inventory.class);
	}
	
	public InventoryItem updateInventoryItems(ProductQueryEntry item) throws IOException
	{
		var obj = client.put("/seller/inventory/scryfall_id/"+item.getScryfallId()+"?language_id="+item.getLanguage()+"&finish_id="+item.getFinishId()+"&condition_id="+item.getCondition(),item,null,JsonObject.class);
		return client.fromJson(obj.get("inventory").getAsJsonObject().toString(), InventoryItem.class);
	}
	
	public InventoryItem deleteInventoryItems(ProductQueryEntry item) throws IOException
	{
		var obj = client.delete("/seller/inventory/scryfall_id/"+item.getScryfallId()+"?language_id="+item.getLanguage()+"&finish_id="+item.getFinishId()+"&condition_id="+item.getCondition(),item,null,JsonObject.class);
		return client.fromJson(obj.get("inventory").getAsJsonObject().toString(), InventoryItem.class);
	}
	
	public InventoryItem deleteInventoryItems(Product item) throws IOException
	{
		var obj = client.delete("/seller/inventory/scryfall_id/"+item.getScryfallId()+"?language_id="+item.getLanguage()+"&finish_id="+item.getFinishId()+"&condition_id="+item.getCondition(),item,null,JsonObject.class);
		return client.fromJson(obj.get("inventory").getAsJsonObject().toString(), InventoryItem.class);
	}
	
	
	public List<PriceVariation> listSinglesPrices() throws IOException
	{
		var arr = client.get("/prices/singles", null, JsonObject.class).get("data").getAsJsonArray();
		return arr.asList().stream().map(e->client.fromJson(e.toString(),PriceVariation.class)).toList();
	}
	
	public List<PriceVariation> listSealedPrices() throws IOException
	{
		var arr = client.get("/prices/sealed", null, JsonObject.class).get("data").getAsJsonArray();
		return arr.asList().stream().map(e->client.fromJson(e.toString(),PriceVariation.class)).toList();
	}
	
	public List<PriceVariation> listVariantsPrices() throws IOException
	{
		var arr = client.get("/prices/variants", null, JsonObject.class).get("data").getAsJsonArray();
		return arr.asList().stream().map(e->client.fromJson(e.toString(),PriceVariation.class)).toList();
	}
	
	public List<OrderSummary> listSellsOrders(int limit, int offset) throws IOException
	{
		var arr = client.get("/seller/orders?limit="+limit+"&offset="+offset, null, JsonObject.class).get("orders").getAsJsonArray();
		return arr.asList().stream().map(e->client.fromJson(e.toString(),OrderSummary.class)).toList();
	}
	
	public List<OrderSummary> listBoughtOrders(int limit, int offset) throws IOException
	{
		var arr = client.get("/buyer/orders?limit="+limit+"&offset="+offset, null, JsonObject.class).get("orders").getAsJsonArray();
		return arr.asList().stream().map(e->client.fromJson(e.toString(),OrderSummary.class)).toList();
	}
	
	public void clearSellerInventory() throws IOException {
		getSellerInventory().forEach(item->{
			try {
				deleteInventoryItems(item.getProduct().getSingle());
			} catch (IOException e) {
				logger.error(e);
			}
		});
	}
	
	
	public Order getSellsOrder(OrderSummary os) throws IOException
	{
		return getSellsOrderById(os.getId());
	}
	
	public Order getBoughtOrderById(String id)throws IOException
	{
		return client.get("/buyer/orders/"+id, null, Order.class);
	}
	
	public Order getBoughtOrder(OrderSummary os)throws IOException
	{
		return getSellsOrderById(os.getId());
	}
	
	public Order getSellsOrderById(String id)throws IOException
	{
		return client.get("/seller/orders/"+id, null, Order.class);
	}
	
	
	public double userCredits() throws IOException
	{
		var arr = client.get("/buyer/credit", null, JsonObject.class).get("user_credit_cents").getAsInt();
		return arr/100.0;
	}
	
	public Account userAccount() throws IOException
	{
		return client.get("/account", null, Account.class);
	}
	
	
	public static Date parseDate(String date)
	{
		try {
			return new SimpleDateFormat(ManaPoolConstants.DATE_FORMAT).parse(date);
		} catch (ParseException e) {
			logger.error(e);
			return null;
		}
	}
	
	public static String toDate(Date date)
	{
			return new SimpleDateFormat(ManaPoolConstants.DATE_FORMAT).format(date);
	}
	
}
