package com.capstone.fincrop.service;

import com.capstone.fincrop.model.SupplierDetails;
import com.capstone.fincrop.repository.SupplierDetailsRepository;
import com.capstone.fincrop.repository.SupplierDetailsRepository;
import com.capstone.fincrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierDetailsService {
	
	@Autowired
	SupplierDetailsRepository supplierDetailsRepository;

	@Autowired
	UserRepository userRepository;

	public List<SupplierDetails> list(){
		return (List<SupplierDetails>) supplierDetailsRepository.findAll();
		
	}
	
	public Boolean save(SupplierDetails supplierDetails) {
		if(supplierDetails.getUser()!= null && !userRepository.findByUsername(supplierDetails.getUser().getUsername()).isPresent()) {
			supplierDetails =supplierDetailsRepository.save(supplierDetails);
			if(supplierDetails.getId() != null) {
				return true;
			}
		}
		return false;
	}

}
