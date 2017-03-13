package com.hujh.spring.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hujh.spring.boot.jpa.dao.PersonRepository;
import com.hujh.spring.boot.jpa.domain.Person;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	@Transactional(rollbackFor=(IllegalArgumentException.class))
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞已存在，数据回滚");
		}
		return p;
	}

	@Override
	@Transactional(noRollbackFor=IllegalArgumentException.class)
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞已存在，数据不回滚");
		}
		return p;
	}

}
