package com.david.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.relationships.models.Dojo;
import com.david.relationships.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	
	void deleteAll();
	
	void deleteById(Long id);
	
	List<Ninja> findByName(String name);
}
