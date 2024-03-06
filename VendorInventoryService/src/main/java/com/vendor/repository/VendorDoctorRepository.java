package com.vendor.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vendor.entity.VendorDoctor;

@Repository
public interface VendorDoctorRepository extends JpaRepository<VendorDoctor, Integer> {

	@Query(value = "select * from doctor_model d inner join vendor_doctor v on d.vendor_id=v.vendor_id where d.vendor_id= ? and d.available_date LIKE ?% and d.is_available=false",nativeQuery = true)
	public List<Object[]>showListOfDoctorsVendor(int vendorId,String date);
}
