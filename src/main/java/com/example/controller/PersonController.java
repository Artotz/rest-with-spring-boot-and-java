package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping(
			produces="application/json")
	public Person findAll() {
		return service.findAll();
	}
	
}
