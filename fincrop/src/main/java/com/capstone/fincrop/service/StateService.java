package com.capstone.fincrop.service;

import com.capstone.fincrop.model.Country;
import com.capstone.fincrop.model.State;
import com.capstone.fincrop.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
	
	@Autowired
	StateRepository stateRepository;

	public List<State> list(String countryId){
		return (List<State>) stateRepository.findByCountryId(countryId);
	}

}
