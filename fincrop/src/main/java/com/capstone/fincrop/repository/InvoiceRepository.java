package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Invoice;
import com.capstone.fincrop.model.SupplierDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    List<Invoice> findByClientDetails(ClientDetails clientDetails);

    List<Invoice> findBySupplierCode(SupplierDetails supplierDetails);

}
