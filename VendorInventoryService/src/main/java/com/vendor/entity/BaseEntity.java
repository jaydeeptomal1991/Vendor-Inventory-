package com.vendor.entity;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long inventoryId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date(System.currentTimeMillis());
	private Date updatedDate;
	private String addedById;
	private String addedByName;
	
	
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getAddedById() {
		return addedById;
	}
	public void setAddedById(String addedById) {
		this.addedById = addedById;
	}
	public String getAddedByName() {
		return addedByName;
	}
	public void setAddedByName(String addedByName) {
		this.addedByName = addedByName;
	}

}
