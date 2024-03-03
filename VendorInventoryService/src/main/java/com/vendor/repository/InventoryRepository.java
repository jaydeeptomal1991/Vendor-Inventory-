package com.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vendor.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByMedicineName(String medicineName);
	
	@Query(value = "SELECT * FROM inventory WHERE medicine_name LIKE ?% and vendor_id =?;",nativeQuery = true)
	List<Inventory> findMedicieneRegex(String medicineName,int vendorId);
	
	@Query(value = "SELECT * FROM inventory WHERE medicine_name LIKE ?% and vendor_id =?;",nativeQuery = true)
	List<Inventory> findMedicineVendor(String medicineName,int vendorId);
	

}
