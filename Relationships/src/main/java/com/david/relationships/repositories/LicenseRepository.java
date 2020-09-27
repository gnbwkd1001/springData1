package com.david.relationships.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll(Sort sort);
	
	List<License> findAll();
	
	void deleteById(Long id);
	
	void deleteAll();

}
