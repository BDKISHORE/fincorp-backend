package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StateRepository extends CrudRepository<State, Long> {

    List<State> findByCountryId(String countryId);
}
