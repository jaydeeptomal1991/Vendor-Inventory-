package com.vendor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.vendor.dto.InvoiceRequest;
import com.vendor.dto.ResponseResult;
import com.vendor.entity.GlobalInventory;
import com.vendor.entity.Inventory;
import com.vendor.entity.InventoryInvoice;
import com.vendor.entity.InvoiceGenerate;
import com.vendor.repository.GlobalInventoryRepository;
import com.vendor.repository.InventoryInvoiceRepository;
import com.vendor.repository.InventoryRepository;
import com.vendor.repository.InvoiceGenerateRepository;

import jakarta.transaction.Transactional;

@Service
public class InvoiceGenerateServiceImp implements InvoiceGenerateService {

	@Autowired
	private InvoiceGenerateRepository invoiceGenerateRepository;
	@Autowired
	private InventoryInvoiceRepository inventoryInvoiceRepository;
	@Autowired
	private InventoryRepository inventoryRepository; 
	@Autowired
	private GlobalInventoryRepository globalInventoryRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceGenerateServiceImp.class);

	@Transactional
	@Override
	public ResponseResult createInvoice(InvoiceRequest invoiceRequest) {
		// TODO Auto-generated method stub 
		try {
			InvoiceGenerate obj = new InvoiceGenerate();
			obj.setVendorId(invoiceRequest.getVendorId()); 
			obj.setVendorName(invoiceRequest.getVendorName().toUpperCase());
			obj.setVendorAddress(invoiceRequest.getVendorAddress().toUpperCase());
			obj.setDiscount(invoiceRequest.getDiscount());
			obj.setFinalPrice(invoiceRequest.getFinalPrice());
			obj.setBilledBy(invoiceRequest.getBilledBy().toUpperCase());
			obj.setDoctorName(invoiceRequest.getDoctorName().toUpperCase());
			InvoiceGenerate invoiceSaved = invoiceGenerateRepository.save(obj);

			for (InventoryInvoice inventoryInvoice : invoiceRequest.getIneventory()) {
				Inventory getInventory = inventoryRepository.findByInventoryId(inventoryInvoice.getInventoryId());
				if (getInventory.getQuantity() < inventoryInvoice.getQuantity()) {
					continue;
				}
				getInventory.setQuantity(getInventory.getQuantity() - inventoryInvoice.getQuantity());
				inventoryRepository.save(getInventory);
				
				invoiceSaved.getIneventory().add(inventoryInvoice);
				inventoryInvoice.setInvoiceGenerate(invoiceSaved);
				
				inventoryInvoiceRepository.save(inventoryInvoice);
				
				// Global Inventory update
				GlobalInventory globalInventory=globalInventoryRepository.findByInventoryId(inventoryInvoice.getInventoryId());
				if (globalInventory.getQuantity() < inventoryInvoice.getQuantity()) {
					continue;
				}
				globalInventory.setQuantity(globalInventory.getQuantity() - inventoryInvoice.getQuantity());
				globalInventoryRepository.save(globalInventory);
				

			}
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", invoiceSaved);

		} catch (Exception ex) {
			LOGGER.error("Error creating invoice" + ex.getLocalizedMessage());
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}
	}

}
