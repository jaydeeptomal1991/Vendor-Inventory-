package com.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.entity.InventoryInvoice;

@Repository
public interface InventoryInvoiceRepository extends JpaRepository<InventoryInvoice, Long> {

}
