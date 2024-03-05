package com.vendor.dto;

import java.util.HashSet;
import java.util.Set;

import com.vendor.entity.DoctorModel;

public class DoctorAppointmentRequest {
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private Set<DoctorModel>doctorList=new HashSet<DoctorModel>();
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
	public Set<DoctorModel> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(Set<DoctorModel> doctorList) {
		this.doctorList = doctorList;
	}
	
	
}
