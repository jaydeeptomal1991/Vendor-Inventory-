package com.vendor.service;

import com.vendor.dto.InvoiceRequest;
import com.vendor.dto.ResponseResult;

public interface InvoiceGenerateService {

	public ResponseResult createInvoice(InvoiceRequest invoiceRequest); 
}
