package com.vendor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String specialist;
	private String availableDate;
	private int visitingFee;
	private boolean isAvailable;
	
	@ManyToOne
	@JoinColumn(name = "vendorId")
	private VendorDoctor vendorDoctor;
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getVisitingFee() {
		return visitingFee;
	}

	public void setVisitingFee(int visitingFee) {
		this.visitingFee = visitingFee;
	}

	@JsonIgnore
	public VendorDoctor getVendorDoctor() {
		return vendorDoctor;
	}

	public void setVendorDoctor(VendorDoctor vendorDoctor) {
		this.vendorDoctor = vendorDoctor;
	}

	
	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



}
