package com.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.dto.DoctorAppointmentRequest;
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
	
	@GetMapping("/showDoctorList/{vendorId}/{date}")
	private ResponseEntity<?> showDoctorListDate(){
		return ResponseEntity.ok(null);
	}
} 
