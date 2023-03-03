package com.example.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.exception.RequiredObjectIsNullException;
import com.example.exception.ResourceNotFoundException;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Executando findAll");

		return repository.findAll();
	}

	public Person findById(Long id){
		logger.info("Executando findById");

		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		return entity;
	}

	public Person create(Person person){
		logger.info("Executando create");

		return repository.save(person);
	}

	public Person update(Person person){	
		logger.info("Executando update");
	
		if (person == null) throw new RequiredObjectIsNullException();

		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());

		return repository.save(entity);
	}

	public void delete(Long id){
		logger.info("Executando delete");

		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}
	
}
