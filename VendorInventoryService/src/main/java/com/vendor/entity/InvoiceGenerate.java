package com.vendor.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Invoice")
public class InvoiceGenerate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long invoiceId;
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private int discount;
	private int finalPrice;
	private String doctorName;
	private String billedBy;
	
	@OneToMany(mappedBy = "invoiceGenerate",cascade = {CascadeType.ALL,CascadeType.REMOVE})
	private List<InventoryInvoice>ineventory=new ArrayList<InventoryInvoice>();
	
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
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
	@Override
	public String toString() {
		return "InvoiceGenerate [invoiceId=" + invoiceId + ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", vendorAddress=" + vendorAddress + ", ineventory=" + ineventory + ", discount=" + discount
				+ ", finalPrice=" + finalPrice + ", doctorName=" + doctorName + ", billedBy=" + billedBy + "]";
	}

}
