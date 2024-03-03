package com.vendor.service;

import java.util.List;

import com.vendor.entity.GlobalInventory;
import com.vendor.entity.Inventory;

public interface InventoryService {
	
	public Inventory createInventory(Inventory inventory);   
	
	public boolean ifIventoryExists(Inventory inventory);
	
	public List<Inventory> checkInventoryStandAlone(String medicine,int vendorId);
	
	public List<GlobalInventory> globalInventoryCheck(String medicine,String vendorAddress);

}
