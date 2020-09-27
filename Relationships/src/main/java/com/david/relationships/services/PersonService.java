package com.david.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.relationships.models.Person;
import com.david.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	public PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPeople(){
		return personRepository.findAll();
	}
	
	public Person registerPerson(Person p) {
		System.out.println("person registered");
		return personRepository.save(p);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
	}
	
	public List<Person> findPerson(String name){
		return personRepository.findByFirstName(name);
	}
	
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
//	public List<Person> findPersonByName(String fir) {
//		List<Person> optionalPerson = personRepository.findByfirstNameContaining(search);
//		return optionalPerson.get();
//		
//	}
}
