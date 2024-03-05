package com.vendor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "InventoryInvoice")
public class InventoryInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long inventoryInvoiceId;
	private long inventoryId;
	private String medicineName;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "invoiceId")
	private InvoiceGenerate invoiceGenerate;
	
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getInventoryInvoiceId() {
		return inventoryInvoiceId;
	}
	public void setInventoryInvoiceId(long inventoryInvoiceId) {
		this.inventoryInvoiceId = inventoryInvoiceId;
	}
	@JsonIgnore
	public InvoiceGenerate getInvoiceGenerate() {
		return invoiceGenerate;
	}
	public void setInvoiceGenerate(InvoiceGenerate invoiceGenerate) {
		this.invoiceGenerate = invoiceGenerate;
	}
	@Override
	public String toString() {
		return "InventoryInvoice [inventoryInvoiceId=" + inventoryInvoiceId + ", inventoryId=" + inventoryId
				+ ", medicineName=" + medicineName + ", quantity=" + quantity + ", price=" + price
				+ ", invoiceGenerate=" + invoiceGenerate + "]";
	}
	
}
