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
	private Date createdInventoryDate = new Date(System.currentTimeMillis());
	private Date updatedInventoryDate;
	private String addedById;
	private String addedByName;

	public Date getCreatedInventoryDate() {
		return createdInventoryDate;
	}

	public void setCreatedInventoryDate(Date createdInventoryDate) {
		this.createdInventoryDate = createdInventoryDate;
	}

	public Date getUpdatedInventoryDate() {
		return updatedInventoryDate;
	}

	public void setUpdatedInventoryDate(Date updatedInventoryDate) {
		this.updatedInventoryDate = updatedInventoryDate;
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
