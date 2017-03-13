package com.hujh.spring.boot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hujh.spring.boot.jpa.domain.Person;
import com.hujh.spring.boot.jpa.service.DemoService;

@RestController
public class MyController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person norollback(Person person) {
		return demoService.savePersonWithoutRollBack(person);
	}
	
}
