package com.vendor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vendor.dto.DoctorAppointmentRequest;
import com.vendor.dto.ResponseResult;
import com.vendor.entity.DoctorModel;
import com.vendor.entity.VendorDoctor;
import com.vendor.repository.DoctorModelRepository;
import com.vendor.repository.VendorDoctorRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorAppointmentImp implements DoctorAppointment {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorAppointmentImp.class);

	@Autowired
	private DoctorModelRepository doctorModelRepository;
	@Autowired
	private VendorDoctorRepository vendorDoctorRepository;

	@Override
	@Transactional
	public ResponseResult addDoctor(DoctorAppointmentRequest doctorAppointmentRequest) {
		// TODO Auto-generated method stub
		try {
			VendorDoctor obj = new VendorDoctor();
			obj.setVendorId(doctorAppointmentRequest.getVendorId());
			obj.setVendorName(doctorAppointmentRequest.getVendorName());
			obj.setVendorAddress(doctorAppointmentRequest.getVendorAddress());
			VendorDoctor obj1 = vendorDoctorRepository.save(obj);
			for (DoctorModel model : doctorAppointmentRequest.getDoctorList()) {
				obj1.getDoctorList().add(model);
				model.setVendorDoctor(obj1);
				doctorModelRepository.save(model);
			}
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCCESS", obj1);
		} catch (Exception ex) {
			LOGGER.error("Error add doctor" + ex.getLocalizedMessage());
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}
	}

}
