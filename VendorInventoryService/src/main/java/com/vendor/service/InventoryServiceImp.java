package com.vendor.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vendor.entity.GlobalInventory;
import com.vendor.entity.Inventory;
import com.vendor.repository.GlobalInventoryRepository;
import com.vendor.repository.InventoryRepository;

@Service
public class InventoryServiceImp implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private GlobalInventoryRepository globalInventoryRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImp.class);

	@Override
	public Inventory createInventory(Inventory inventory) {
		try {
			// TODO Auto-generated method stub
			Inventory newInventory = null;
			Inventory object = findInventoryVendor(inventory.getMedicineName(), inventory.getVendorId());
			if (object != null && object.getPrice() == inventory.getPrice()) {
				object.setVendorName(inventory.getVendorName().toLowerCase());
				object.setVendorId(inventory.getVendorId());
				object.setBrandName(inventory.getBrandName().toLowerCase());
				object.setPrice(inventory.getPrice());
				object.setExpiryDate(inventory.getExpiryDate());
				object.setMedicineName(inventory.getMedicineName().toLowerCase());
				object.setQuantity(inventory.getQuantity() + object.getQuantity());
				object.setVendorAddress(inventory.getVendorAddress().toLowerCase());
				newInventory = inventoryRepository.save(object);
				
				// Find Global Inventory
				
				GlobalInventory getGlobal=findMedicineVendorGlobal(inventory.getMedicineName(), inventory.getVendorId());
				getGlobal.setVendorName(inventory.getVendorName().toLowerCase());
				getGlobal.setVendorId(inventory.getVendorId());
				getGlobal.setBrandName(inventory.getBrandName().toLowerCase());
				getGlobal.setPrice(inventory.getPrice());
				getGlobal.setExpiryDate(inventory.getExpiryDate());
				getGlobal.setMedicineName(inventory.getMedicineName().toLowerCase());
				getGlobal.setQuantity(inventory.getQuantity()+getGlobal.getQuantity());
				getGlobal.setVendorAddress(inventory.getVendorAddress().toLowerCase());
				globalInventoryRepository.save(getGlobal);
				
			} else {
				newInventory = inventoryRepository.save(inventory);
				
				// Global Inventory
				GlobalInventory globalInv = new GlobalInventory();
				globalInv.setVendorName(inventory.getVendorName().toLowerCase());
				globalInv.setVendorId(inventory.getVendorId());
				globalInv.setBrandName(inventory.getBrandName().toLowerCase());
				globalInv.setPrice(inventory.getPrice());
				globalInv.setExpiryDate(inventory.getExpiryDate());
				globalInv.setMedicineName(inventory.getMedicineName().toLowerCase());
				globalInv.setQuantity(inventory.getQuantity());
				globalInv.setVendorAddress(inventory.getVendorAddress().toLowerCase());
				globalInventoryRepository.save(globalInv);
			}
			

			return newInventory;
		} catch (Exception ex) {
			LOGGER.error("Error saving inventory " + ex.getLocalizedMessage());
			return null;
		}
	}
		
	
	// StandAlone Inventory
	public Inventory findInventoryVendor(String medName, int vendorId) {
		Inventory inventory = null;
		String med[]=medName.split(" ");
		List<Inventory> o = inventoryRepository.findMedicineVendor(med[0], vendorId);
		for (Inventory o1 : o) {
			if (o1.getMedicineName().replaceAll("\\s", "").equalsIgnoreCase(medName.replaceAll("\\s", ""))) {
				inventory = o1;
				break;
			}
		}
		return inventory;

	}
	
	// Global Inventory
	public GlobalInventory findMedicineVendorGlobal(String medName, int vendorId) {
		GlobalInventory inventory = null;
		String med[]=medName.split(" ");
		List<GlobalInventory> o = globalInventoryRepository.findMedicineVendor(med[0], vendorId);
		for (GlobalInventory o1 : o) {
			if (o1.getMedicineName().replaceAll("\\s", "").equalsIgnoreCase(medName.replaceAll("\\s", ""))) {
				inventory = o1;
				break;
			}
		}
		return inventory;

	}

	@Override
	public boolean ifIventoryExists(Inventory inventory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Inventory> checkInventoryStandAlone(String medicine, int vendorId) {
		try {
			medicine = medicine.toLowerCase();
			List<Inventory> obj = inventoryRepository.findMedicieneRegex(medicine, vendorId);
			return obj;
		} catch (Exception ex) {
			LOGGER.error("Error show inventory " + ex.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public List<GlobalInventory> globalInventoryCheck(String medicine, String vendorAddress) {
		try {
			medicine = medicine.toLowerCase();
			List<GlobalInventory> obj = globalInventoryRepository.findMedicieneRegex(medicine, vendorAddress);
			return obj;
		} catch (Exception ex) {
			LOGGER.error("Error show inventory " + ex.getLocalizedMessage());
			return null;
		}
	}

}
