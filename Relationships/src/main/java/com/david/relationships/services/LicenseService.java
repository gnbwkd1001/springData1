package com.david.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.relationships.models.License;
import com.david.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	public LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicense(){
		return licenseRepository.findAll();
	}
	
	public License registerLicense(License l) {
		System.out.println("License Service : License registered");
		return licenseRepository.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else {
			return null;
		}
	}
	
	public void deleteAll() {
		licenseRepository.deleteAll();
	}
	
	
}
