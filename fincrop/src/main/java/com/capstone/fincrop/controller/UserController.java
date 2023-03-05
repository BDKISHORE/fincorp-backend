package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.Register;
import com.capstone.fincrop.model.User;
import com.capstone.fincrop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

//	@CrossOrigin("*")
//	@PostMapping("/create")
//	ResponseEntity<Register> create(@RequestBody User user) {
//
//		if(userService.save(user)) {
//			Register register = new Register("200", "Successfully Register");
//			return ResponseEntity.ok(register);
//		} else {
//			return ResponseEntity.internalServerError().body("Username is already exist");
//		}
//	}

	@CrossOrigin("*")
	@PostMapping("/authenticate")
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		Optional<User> userOptional = userService.findByUserAndPassword(user);
		if(userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		}
		return ResponseEntity.ok(user);
	}

}
