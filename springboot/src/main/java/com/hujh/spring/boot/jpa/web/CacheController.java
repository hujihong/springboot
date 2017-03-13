package com.hujh.spring.boot.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hujh.spring.boot.jpa.domain.Person;
import com.hujh.spring.boot.jpa.service.CacheService;

@RestController
public class CacheController {
	
	@Autowired
	CacheService cacheService;
	
	@RequestMapping("/put")
	public Person put(Person person){
		return cacheService.save(person);
		
	}

	@RequestMapping("/able")
	public Person cacheable(Person person){
		return cacheService.findOne(person);
	}
	
	@RequestMapping("/evit")
	public String  evit(Long id){
		cacheService.remove(id);
		 return "ok";
	}
	
}
