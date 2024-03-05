package com.vendor.service;

import com.vendor.dto.DoctorAppointmentRequest;
import com.vendor.dto.ResponseResult;

public interface DoctorAppointment {

	public ResponseResult addDoctor(DoctorAppointmentRequest vendorDoctor);
}
