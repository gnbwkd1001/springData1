package com.david.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.relationships.models.License;
import com.david.relationships.models.Person;
import com.david.relationships.services.LicenseService;
import com.david.relationships.services.PersonService;

@Controller
public class PersonAPI {
	public PersonService personService;
	
	public LicenseService licenseService;
	
	public PersonAPI(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	
	@RequestMapping("/")
	public String domain(Model model) {
		List<Person> allPeople = personService.allPeople();
		List<License> allLicense = licenseService.allLicense();
//		System.out.println(allLicense);
		model.addAttribute("people", allPeople);
		model.addAttribute("license", allLicense);
		return "domain.jsp";
	}
	
	@RequestMapping("/register/person")
	public String newPerson() {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/newPerson", method=RequestMethod.POST)
	public String registerPerson(@RequestParam(value="firstName") String fname) {
		Person person = new Person(fname);
		personService.registerPerson(person);
		return "redirect:/";
	}
	
	@RequestMapping(value="/newLicense", method=RequestMethod.POST)
	public String registerLicense(@RequestParam(value="person") Long id, @RequestParam(value="state") String state, @RequestParam(value="date") String date, Model model) throws ParseException {
		String licenseNumber = "000001";
		Date dateDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//		System.out.println("*********register License API Param Info***********");
//		System.out.println(id);
//		System.out.println(state);
//		System.out.println(date);
		License license = new License(licenseNumber, dateDate, state);
		licenseService.registerLicense(license);
		
		Person person = personService.findPerson(id);
		System.out.println(license);
		System.out.println(person);
		person.setLicense(license);
		license.setPerson(person);
		personService.registerPerson(person);
		model.addAttribute("apiLicense", license);
		return "redirect:/";
	}
	
	@RequestMapping("/register/license")
	public String newLicense(Model model) {
		List<Person> allPeople = personService.allPeople();
		model.addAttribute("people", allPeople);
		return "newLicense.jsp";
	}
	
	@RequestMapping("/person/{id}")
	public String personInfo(@PathVariable("id") Long id, Model model ) {
		Person person = personService.findPerson(id);
		System.out.println(person.getLicense().getNumber());
		model.addAttribute("person", person);
		
		return "personInfo.jsp";
	}
	
	@RequestMapping("/license/{id}")
	public String licenseInfo(@PathVariable("id") Long id, Model model) {
		License license = licenseService.findLicense(id);
		model.addAttribute("license", license);
		return "licenseInfo.jsp";
	}
//	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		licenseService.deleteAll();
		return "redirect:/";
	}
}
