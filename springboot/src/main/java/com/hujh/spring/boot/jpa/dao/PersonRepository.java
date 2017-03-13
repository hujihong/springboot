package com.hujh.spring.boot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.hujh.spring.boot.jpa.domain.Person;

// http://127.0.0.1:8081/api/people?page=3&size=1
// http://127.0.0.1:8081/api/people?sort=age,asc
// http://127.0.0.1:8081/api/people  post方法 json {"name":"cc", "address":"成都", "age":21}
// http://127.0.0.1:8081/api/people/1 put方式 {"name":"汪云飞", "address":"合肥", "age":40}
// http://127.0.0.1:8081/api/people/14 delete方式
@RepositoryRestResource(path = "people")
// public interface PersonRepository extends CustomRepository<Person, Long> {
 public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name,String address);
	
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
	
	Person withNameAndAddressNamedQuery(String name,String address);

	// http://127.0.0.1:8081/api/people/search/nameStartsWith?name=%E6%B1%AA
	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	Person findByNameStartsWith(@Param("name")String name);
	
}
