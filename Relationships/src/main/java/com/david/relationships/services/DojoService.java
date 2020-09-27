package com.david.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.relationships.models.Dojo;
import com.david.relationships.models.Person;
import com.david.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	public DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();
	}
	
	public Dojo registerDojo(Dojo d) {
		System.out.println("Dojo service : Dojo registered");
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
	public List<Dojo> findDojoById(Long id){
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		return (List<Dojo>) optionalDojo.get();
	}
	
	public List<Dojo> findDojo(String name){
		return dojoRepository.findByName(name);
	}
	
	public void deleteAll() {
		dojoRepository.deleteAll();
	}
}