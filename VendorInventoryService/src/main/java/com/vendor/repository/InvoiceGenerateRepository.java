package com.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vendor.entity.InvoiceGenerate;

@Repository
public interface InvoiceGenerateRepository extends JpaRepository<InvoiceGenerate, Long> {

}
