package com.hujh.spring.boot.jpa.service;

import com.hujh.spring.boot.jpa.domain.Person;

public interface CacheService {
	
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);
}
