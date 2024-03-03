package com.vendor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.dto.ResponseResult;
import com.vendor.entity.GlobalInventory;
import com.vendor.entity.Inventory;
import com.vendor.service.InventoryServiceImp;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	private static final Logger LOGGER= LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryServiceImp inventoryServiceImp;
	
	@GetMapping("/test")
	private String test() {
		return "Inventory Test";
	}
	
	@PostMapping("/addInventory")
	private ResponseEntity<?> addMedicineInventory(@RequestBody Inventory inventory){
		Inventory object=inventoryServiceImp.createInventory(inventory);
		if(object!=null) {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", object));
		}else {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED"));
		}
	}
	
	@GetMapping("/searchMedicineStandAlone/{name}/{vendorId}")      
	private ResponseEntity<?> searchMedicineStandAlone(@PathVariable("name")String name,@PathVariable("vendorId")int vendorId){
		List<Inventory> object=inventoryServiceImp.checkInventoryStandAlone(name,vendorId);
		if(object!=null) {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", object));
		}else {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED"));
		}
	}
	
	@GetMapping("/searchMedicine/{name}/{vendorAddress}")      
	private ResponseEntity<?> searchMedicineGlobal(@PathVariable("name")String name,@PathVariable("vendorAddress")String vendorAddress){
		List<GlobalInventory> object=inventoryServiceImp.globalInventoryCheck(name,vendorAddress);
		if(object!=null) {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", object));
		}else {
			return ResponseEntity.ok(new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED"));
		}
	}
	
}
