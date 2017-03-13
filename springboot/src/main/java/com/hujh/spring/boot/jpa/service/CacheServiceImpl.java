package com.hujh.spring.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hujh.spring.boot.jpa.dao.PersonRepository;
import com.hujh.spring.boot.jpa.domain.Person;

@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	@CachePut(value = "people", key = "#person.id") // 缓存名称为people,数据key是person的id
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
		return p;
	}

	@Override
	@CacheEvict(value = "people")//2 从缓存people中删除key为id数据 ps:如果没有key, 则方法参数作为key保存到缓存中
	public void remove(Long id) {
		System.out.println("删除了id、key为"+id+"的数据缓存");
		//这里不做实际删除操作
	}

	@Override
	@Cacheable(value = "people", key = "#person.id") //3 缓存key为person的id数据到缓存people中
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
		return p;
	}
	

}
