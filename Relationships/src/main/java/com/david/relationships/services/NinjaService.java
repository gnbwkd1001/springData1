package com.david.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.relationships.models.Dojo;
import com.david.relationships.models.Ninja;
import com.david.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	public NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinja(){
		return ninjaRepository.findAll();
	}
	
	public Ninja registerNinja(Ninja n) {
		System.out.println("Ninja Service : Ninja registered!");
		return ninjaRepository.save(n);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		return optionalNinja.get();
	}
	
	public List<Ninja> findNinjaById(Long id){
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		return (List<Ninja>) optionalNinja.get();
	}
	
	public List<Ninja> findNinjaByName(String name){
		return ninjaRepository.findByName(name);
	}
	
	public void deleteAll() {
		ninjaRepository.deleteAll();
	}
}
