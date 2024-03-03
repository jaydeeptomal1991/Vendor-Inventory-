package com.vendor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vendor.entity.GlobalInventory;


@Repository
public interface GlobalInventoryRepository extends JpaRepository<GlobalInventory, Long> {

	GlobalInventory findByVendorId(int vendorId);
	
	@Query(value = "SELECT * FROM global_inventory WHERE medicine_name LIKE ?% and vendor_address like ?%;",nativeQuery = true)
	List<GlobalInventory> findMedicieneRegex(String medicineName,String vendorAddress); 
	
	@Query(value = "SELECT * FROM global_inventory WHERE medicine_name LIKE ?% and vendor_id =?;",nativeQuery = true)
	List<GlobalInventory> findMedicineVendor(String medicineName,int vendorId);

}
