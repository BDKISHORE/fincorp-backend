package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {

    Optional<ClientDetails> findByUser(User user);

}
