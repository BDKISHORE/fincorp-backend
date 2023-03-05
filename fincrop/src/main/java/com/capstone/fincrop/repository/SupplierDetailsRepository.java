package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.SupplierDetails;
import com.capstone.fincrop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierDetailsRepository extends CrudRepository<SupplierDetails, Long> {

    Optional<SupplierDetails> findByUser(User user);

}
