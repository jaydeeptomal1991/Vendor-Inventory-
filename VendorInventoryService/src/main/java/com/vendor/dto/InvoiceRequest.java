package com.vendor.dto;

import java.util.List;
import com.vendor.entity.InventoryInvoice;

public class InvoiceRequest {
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private List<InventoryInvoice>ineventory;
	private int discount;
	private int finalPrice;
	private String doctorName;
	private String billedBy;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public List<InventoryInvoice> getIneventory() {
		return ineventory;
	}
	public void setIneventory(List<InventoryInvoice> ineventory) {
		this.ineventory = ineventory;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getBilledBy() {
		return billedBy;
	}
	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
