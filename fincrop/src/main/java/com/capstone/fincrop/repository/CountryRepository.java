package com.capstone.fincrop.repository;

import com.capstone.fincrop.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
