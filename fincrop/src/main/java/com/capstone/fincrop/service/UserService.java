package com.capstone.fincrop.service;

import com.capstone.fincrop.model.User;
import com.capstone.fincrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Boolean save(User user) {
		if(!userRepository.findByUsername(user.getUsername()).isPresent()) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	public Boolean findByUser(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			return true;
		}
		return false;
	}

	public Optional<User> findByUserAndPassword(User user) {
		Optional<User> userOptional = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userOptional.isPresent()) {
			return userOptional;
		}
		return Optional.empty();
	}

}
