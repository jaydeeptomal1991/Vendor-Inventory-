package com.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vendor.dto.InvoiceRequest;
import com.vendor.service.InvoiceGenerateServiceImp;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceGenerateServiceImp invoiceGenerateServiceImp;
	
	@PostMapping("/createInvoice/{vendorId}")
	private ResponseEntity<?> createInvoice(@PathVariable("vendorId")int vendorId,@RequestBody InvoiceRequest invoiceRequest){
		return ResponseEntity.ok(invoiceGenerateServiceImp.createInvoice(invoiceRequest));
	}
}
