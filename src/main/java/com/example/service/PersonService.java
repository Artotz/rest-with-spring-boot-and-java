package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonService {
	
	public Person findAll() {
		Person person = new Person();

		person.setFirstName("Johnny");
		person.setLastName("Gordo");
		person.setAddress("Fortaleza - Ceará");
		
		return person;
	}
	
}
