package com.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vendor.entity.BookAppointmentModel;

@Repository
public interface BookAppointmentRepository extends JpaRepository<BookAppointmentModel, Integer> {
	
	@Query(value = "select * from book_appointment_customer where vendor_id=? and appointment_date like ?% and doctor_id=?;",nativeQuery = true)
	public List<Object[]>showListOfPatients(int vendorId,String appointmentDate,int doctorId);

}
