package com.capstone.fincrop.service;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Country;
import com.capstone.fincrop.repository.ClientDetailsRepository;
import com.capstone.fincrop.repository.CountryRepository;
import com.capstone.fincrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;

	public List<Country> list(){
		return (List<Country>) countryRepository.findAll();
	}

}
