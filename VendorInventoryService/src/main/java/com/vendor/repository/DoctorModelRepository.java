package com.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.entity.DoctorModel;

@Repository
public interface DoctorModelRepository extends JpaRepository<DoctorModel, Integer> {

}
