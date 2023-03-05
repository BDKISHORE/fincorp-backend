package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.City;
import com.capstone.fincrop.model.State;
import com.capstone.fincrop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityService;

	@CrossOrigin("*")
	@GetMapping("/list/{stateId}")
	List<City> list(@PathVariable("stateId") String stateId) {
		try {
			return cityService.list(stateId);
		} catch(Exception e) {
			return new ArrayList<>();
		}
	}
}
