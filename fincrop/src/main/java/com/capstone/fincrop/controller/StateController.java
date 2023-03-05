package com.capstone.fincrop.controller;

import com.capstone.fincrop.model.Country;
import com.capstone.fincrop.model.State;
import com.capstone.fincrop.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	StateService stateService;

	@CrossOrigin("*")
	@GetMapping("/list/{countryId}")
	List<State> list(@PathVariable("countryId") String countryId) {
		try {
			return stateService.list(countryId);
		} catch(Exception e) {
			return new ArrayList<>();
		}
	}
}
