package com.hujh.spring.boot.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.hujh.spring.boot.db.entity.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer> {

}
