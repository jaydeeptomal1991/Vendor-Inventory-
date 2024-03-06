package com.vendor.service;

import com.vendor.dto.BookAppointmentRequest;
import com.vendor.dto.AppointmentRequestDTO;
import com.vendor.dto.DoctorAppointmentRequest;
import com.vendor.dto.ResponseResult;
import com.vendor.dto.SearchDoctorRequest;

public interface DoctorAppointment {

	public ResponseResult addDoctor(DoctorAppointmentRequest vendorDoctor);
	
	public ResponseResult showDoctorsByVendor(SearchDoctorRequest searchDoctorRequest);
	
	public ResponseResult cancelAppointmentVendor(AppointmentRequestDTO cancelAppointmentVendor);
	
	public ResponseResult bookAppointmentCustomer(BookAppointmentRequest bookAppointmentRequest);
	
	public ResponseResult showPatientLists(AppointmentRequestDTO appointmentRequestDTO);
}
