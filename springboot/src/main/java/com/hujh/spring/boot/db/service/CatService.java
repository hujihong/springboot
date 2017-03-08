package com.hujh.spring.boot.db.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hujh.spring.boot.db.dao.CatRepository;
import com.hujh.spring.boot.db.entity.Cat;

@Service
public class CatService {
	
	@Resource
	private CatRepository catRepository;
	
	@Transactional
	public void save(Cat cat) {
		catRepository.save(cat);
	}
	
	@Transactional
	public void delete(int id) {
		catRepository.delete(id);
	}
	
	public Iterable<Cat> getAll() {
		return catRepository.findAll();
	}
	
	
}
