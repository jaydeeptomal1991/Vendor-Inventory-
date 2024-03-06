package com.vendor.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vendor.dto.AppointmentRequestDTO;
import com.vendor.dto.BookAppointmentRequest;
import com.vendor.dto.BookingCustomerResponse;
import com.vendor.dto.DoctorAppointmentRequest;
import com.vendor.dto.ResponseResult;
import com.vendor.dto.SearchDoctorRequest;
import com.vendor.entity.BookAppointmentModel;
import com.vendor.entity.DoctorModel;
import com.vendor.entity.VendorDoctor;
import com.vendor.repository.BookAppointmentRepository;
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
	@Autowired
	private BookAppointmentRepository bookAppointmentRepository;

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

	@Override
	public ResponseResult showDoctorsByVendor(SearchDoctorRequest searchDoctorRequest) {
		// TODO Auto-generated method stub
		try {
			List<Object[]> list = vendorDoctorRepository.showListOfDoctorsVendor(searchDoctorRequest.getVendorId(),
					searchDoctorRequest.getAppointmentDate());
			List<DoctorModel> list1 = new ArrayList<>();
			for (Object[] obj : list) {
				DoctorModel d = new DoctorModel();
				d.setAvailableDate((String) obj[1]);
				d.setDoctorName((String) obj[2]);
				d.setSpecialist((String) obj[4]);
				d.setVisitingFee((Integer) obj[5]);
				list1.add(d);
			}
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", list1);
		} catch (Exception ex) {
			LOGGER.error("Error fetching doctor list:  " + ex.getLocalizedMessage());
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}
	}

	@Override
	public ResponseResult cancelAppointmentVendor(AppointmentRequestDTO cancelAppointmentVendor) {
		// TODO Auto-generated method stub
		try {
			DoctorModel obj = doctorModelRepository.findById(cancelAppointmentVendor.getDoctorId()).get();
			obj.setAvailable(false);
			DoctorModel d = doctorModelRepository.save(obj);
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "Doctor Appointment cancelled", d);
		} catch (Exception ex) {
			LOGGER.error("Error Cancelling Appointment:  " + ex.getLocalizedMessage());
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}
	}

	@Override
	@Transactional
	public ResponseResult bookAppointmentCustomer(BookAppointmentRequest bookAppointmentRequest) {
		// TODO Auto-generated method stub
		try {
			BookAppointmentModel model = new BookAppointmentModel();
			model.setAppointmentDate(bookAppointmentRequest.getAppointmentDate());
			model.setCustomerAddress(bookAppointmentRequest.getCustomerAddress());
			model.setCustomerName(bookAppointmentRequest.getCustomerName());
			model.setPhoneNumber(bookAppointmentRequest.getPhoneNumber());
			model.setCustomerAddress(bookAppointmentRequest.getCustomerAddress());
			model.setDoctorId(bookAppointmentRequest.getDoctorId());
			model.setVendorId(bookAppointmentRequest.getVendorId());
			BookAppointmentModel bookAppointment = bookAppointmentRepository.save(model);
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", bookAppointment);
		} catch (Exception ex) {
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}

	}

	@Override
	public ResponseResult showPatientLists(AppointmentRequestDTO appointmentRequestDTO) {
		// TODO Auto-generated method stub
		try {
			List<Object[]> bookAppointment = bookAppointmentRepository.showListOfPatients(
					appointmentRequestDTO.getVendorId(), appointmentRequestDTO.getAppointmentDate(),
					appointmentRequestDTO.getDoctorId());
			List<BookingCustomerResponse>list=new ArrayList<>();
			for(Object[]obj:bookAppointment) {
				BookingCustomerResponse model=new BookingCustomerResponse();
				model.setAppointmentDate((String)obj[1]);
				model.setCustomerAddress((String)obj[2]);
				model.setCustomerName((String)obj[3]);
				model.setPhoneNumber((String)obj[5]);
				list.add(model);
			}
			return new ResponseResult(HttpStatus.ACCEPTED.value(), "SUCCESS", list);
		} catch (Exception ex) {
			return new ResponseResult(HttpStatus.BAD_REQUEST.value(), "FAILED");
		}
	}

}
