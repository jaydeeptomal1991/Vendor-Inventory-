package com.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.entity.VendorDoctor;

@Repository
public interface VendorDoctorRepository extends JpaRepository<VendorDoctor, Integer> {

}
