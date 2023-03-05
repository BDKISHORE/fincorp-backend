package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.City;
import com.capstone.fincrop.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findByStateId(String stateId);
}
