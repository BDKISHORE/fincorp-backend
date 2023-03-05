package com.capstone.fincrop.service;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.User;
import com.capstone.fincrop.repository.ClientDetailsRepository;
import com.capstone.fincrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientDetailsService {
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;

	@Autowired
	UserRepository userRepository;

	public List<ClientDetails> list(){
		return (List<ClientDetails>) clientDetailsRepository.findAll();
	}
	
	public Boolean save(ClientDetails clientDetails) {
		if(!userRepository.findByUsername(clientDetails.getUser().getUsername()).isPresent()) {
			clientDetails = clientDetailsRepository.save(clientDetails);
			if(clientDetails.getId() != null) {
				return true;
			}
		}
		return false;
	}

}
