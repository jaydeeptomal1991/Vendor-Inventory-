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
	private String appointmentTime;
	private int visitingFee;
	
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

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
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

	@Override
	public String toString() {
		return "DoctorModel [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialist=" + specialist
				+ ", availableDate=" + availableDate + ", appointmentTime=" + appointmentTime + ", visitingFee="
				+ visitingFee + ", vendorDoctor=" + vendorDoctor + "]";
	} 
	

	
}
