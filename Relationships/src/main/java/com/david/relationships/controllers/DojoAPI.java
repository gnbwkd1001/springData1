package com.david.relationships.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.relationships.models.Dojo;
import com.david.relationships.models.Ninja;
import com.david.relationships.services.DojoService;
import com.david.relationships.services.NinjaService;

@Controller
public class DojoAPI {
	public DojoService dojoService;
	
	public NinjaService ninjaService;
	
	public DojoAPI(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojo")
	public String dojoDomain(Model model) {
		List<Dojo> allDojo = dojoService.allDojo();
		List<Ninja> allNinja = ninjaService.allNinja();
		model.addAttribute("dojo", allDojo);
//		System.out.println(allDojo.get(0).getNinjas().size()); 
		
//		Ninja ninja = new Ninja();
//		ninja.setAge(12);
//		ninja.setDojo(allDojo.get(0));
//		ninja.setName("ninja one");
////		ninjaService.registerNinja(ninja);
//		List<Ninja> ninjaList = ninjaService.findNinjaByName(ninja.getName());
//		System.out.println(ninja.getName());
//		System.out.println(ninja.getAge());
//		System.out.println(ninja.getDojo().getName());
//		allDojo.get(0).setNinjas(ninjaList);
//		dojoService.registerDojo(allDojo.get(0));
//		model.addAttribute("ninja", ninja);
		
		return "dojoDomain.jsp";
	}
	
	@RequestMapping("/dojo/{id}")
	public String dojoInfo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("ninjas", dojo.getNinjas());
		
		return "dojoInfo.jsp";
	}
	
	@RequestMapping("/register/dojo")
	public String newDojo() {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/newDojo", method=RequestMethod.POST)
	public String registerDojo(@RequestParam(value="name") String name) {
		Dojo dojo = new Dojo(name);
		dojoService.registerDojo(dojo);
		return "redirect:/dojo";
	}
	
	@RequestMapping("/register/ninja")
	public String newNinja(Model model) {
		List<Dojo> allDojo = dojoService.allDojo();
		model.addAttribute("dojo", allDojo);
		return "newNinja.jsp";
	}
	
	
	
	@RequestMapping(value="/newNinja", method=RequestMethod.POST)
	public String registerNinja(@RequestParam(value="dojo") String dojo, @RequestParam(value="name") String name, @RequestParam(value="age") int age, Model model) {
		Ninja ninja = new Ninja(name, age);
		ninjaService.registerNinja(ninja);
		List<Dojo> dojoFind = dojoService.findDojo(dojo);
//		System.out.println(ninja);
//		System.out.println(dojo);
//		System.out.println(dojoFind.get(0));
//		System.out.println(dojoFind);
		List<Ninja> ninjaList = ninjaService.findNinjaByName(ninja.getName());
//		System.out.println((List<Ninja>) ninjaList);
//		System.out.println((List<Ninja>) ninja);
		dojoFind.get(0).setNinjas(ninjaList);
//		System.out.println(dojoFind.get(0));
		ninja.setDojo(dojoFind.get(0));
		dojoService.registerDojo(dojoFind.get(0));
		model.addAttribute("dojos", dojoFind.get(0));
		model.addAttribute("ninja", ninja);
		return "redirect:/dojo";
	}
	
	@RequestMapping("/deleteA")
	public String deleteA() {
//		dojoService.deleteAll();
		ninjaService.deleteAll();
		return "newNinja.jsp";
	}
}
