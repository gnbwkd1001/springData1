package com.david.relationships.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll(Sort sort);
	
	List<Person> findAll();
	
	void deleteById(Long id);
	
	void deleteAll();
	
	List<Person> findByFirstName(String name);
	
//	List<Person> findAllByArtist(String search);
	
//	List<Person> findTop5ByOrderByRatingDesc(); 
}
