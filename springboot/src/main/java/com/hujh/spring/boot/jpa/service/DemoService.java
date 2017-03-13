package com.hujh.spring.boot.jpa.service;

import com.hujh.spring.boot.jpa.domain.Person;

public interface DemoService {

	public Person savePersonWithRollBack(Person person);
	
	public Person savePersonWithoutRollBack(Person person);
	
}
