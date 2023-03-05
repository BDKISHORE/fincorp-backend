package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Register;
import com.capstone.fincrop.model.User;
import com.capstone.fincrop.service.ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/client-details")
public class ClientDetailsController {
	
	@Autowired
	ClientDetailsService clientDetailsService;
	
	@GetMapping("/list")
	List<ClientDetails> list() {
		return clientDetailsService.list();
	}

	@CrossOrigin("*")
	@PostMapping("/create")
	ResponseEntity<Register> create(@RequestBody ClientDetails clientDetails) {
		try {
			if(clientDetailsService.save(clientDetails)) {
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
