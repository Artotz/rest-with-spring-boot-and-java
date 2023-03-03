package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping(
		produces={"application/json"})
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping(
		path="/{id}",
		produces={"application/json"}
	)
	public Person findById(@PathVariable(value="id") Long id){
		return service.findById(id);
	}

	@PostMapping(
		consumes={"application/json"},
		produces={"application/json"}
	)
	public Person create(@RequestBody Person person){
		return service.create(person);
	}

	@PutMapping(
		consumes={"application/json"},
		produces={"application/json"}
	)
	public Person update(@RequestBody Person person){
		return service.update(person);
	}

	@DeleteMapping(
		path="/{id}"
	)
	public void delete(@PathVariable(value = "id") Long id){
		service.delete(id);
	}
	
}
