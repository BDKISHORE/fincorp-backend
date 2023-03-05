package com.capstone.fincrop.service;

import com.capstone.fincrop.model.City;
import com.capstone.fincrop.model.State;
import com.capstone.fincrop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;

	public List<City> list(String stateId){
		return (List<City>) cityRepository.findByStateId(stateId);
	}

}
