package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Register;
import com.capstone.fincrop.model.SupplierDetails;
import com.capstone.fincrop.service.SupplierDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/supplier-details")
public class SupplierDetailsController {
	
	@Autowired
	SupplierDetailsService supplierDetailsService;
	
	@GetMapping("/list")
	List<SupplierDetails> list() {
		return supplierDetailsService.list();
	}

	@PostMapping("/create")
	ResponseEntity<Register> create(@RequestBody SupplierDetails supplierDetails) {
		try {
			if(supplierDetailsService.save(supplierDetails)) {
				Register register = new Register("200", "Successfully Register");
				return ResponseEntity.ok(register);
			} else {
				Register register = new Register("500", "Username is already exist");
				return ResponseEntity.ok(register);
			}
		} catch(Exception e) {
			Register register = new Register("500", "Something went wrong, please register once again");
			return ResponseEntity.ok(register);
		}
	}



}
