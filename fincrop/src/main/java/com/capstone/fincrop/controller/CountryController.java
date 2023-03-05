package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Country;
import com.capstone.fincrop.repository.CountryRepository;
import com.capstone.fincrop.service.ClientDetailsService;
import com.capstone.fincrop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;

	@CrossOrigin("*")
	@GetMapping("/list")
	List<Country> list() {
		try {
			return countryService.list();
		} catch(Exception e) {
			return new ArrayList<>();
		}
	}
}
