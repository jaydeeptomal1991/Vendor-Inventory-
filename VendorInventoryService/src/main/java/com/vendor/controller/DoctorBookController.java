package com.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.dto.BookAppointmentRequest;
import com.vendor.dto.AppointmentRequestDTO;
import com.vendor.dto.DoctorAppointmentRequest;
import com.vendor.dto.SearchDoctorRequest;
import com.vendor.service.DoctorAppointmentImp;


@RestController
@RequestMapping("/appointment")
public class DoctorBookController {
	
	@Autowired
	private DoctorAppointmentImp doctorAppointmentImp;

	@PostMapping("/addDoctor")
	private ResponseEntity<?> addDoctorVendor(@RequestBody DoctorAppointmentRequest doctorAppointmentRequest){
		return ResponseEntity.ok(doctorAppointmentImp.addDoctor(doctorAppointmentRequest));
	}
	
	@GetMapping("/showDoctorList")
	private ResponseEntity<?> showDoctorListDate(@RequestBody SearchDoctorRequest searchDoctorAppointment){
		return ResponseEntity.ok(doctorAppointmentImp.showDoctorsByVendor(searchDoctorAppointment));
	}
	
	@PatchMapping("/cancelAppointmentVendor")
	private ResponseEntity<?> cancelAppointmentVendor(@RequestBody AppointmentRequestDTO cancelAppointmentVendor){
		return ResponseEntity.ok(doctorAppointmentImp.cancelAppointmentVendor(cancelAppointmentVendor));
	}
	
	@PostMapping("/bookDoctorAppointment")
	private ResponseEntity<?> bookDoctorAppointment(@RequestBody BookAppointmentRequest bookAppointmentRequest ){
		return ResponseEntity.ok(doctorAppointmentImp.bookAppointmentCustomer(bookAppointmentRequest));
	}
	
	@GetMapping("/checkPatientsList")
	private ResponseEntity<?> showPatientsOfAdoctor(@RequestBody AppointmentRequestDTO appointmentRequestDTO){
		return ResponseEntity.ok(doctorAppointmentImp.showPatientLists(appointmentRequestDTO));
	}
} 
        