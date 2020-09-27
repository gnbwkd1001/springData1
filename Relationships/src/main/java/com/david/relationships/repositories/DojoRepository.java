package com.david.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.relationships.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
	
	void deleteAll();
	
	void deleteById(Long id);
	
	List<Dojo> findByName(String name);
}
