package com.fundsperson.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundsperson.spring.datajpa.model.Person;
import com.fundsperson.spring.datajpa.repository.PersonRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPerson(@RequestParam(required = false) String name) {
		try {
			List<Person> per = new ArrayList<Person>();

			if (name == null){
				personRepository.findAll().forEach(per::add);
			}
			if (per.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(per, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
		Optional<Person> personData = personRepository.findById(id);

		if (personData.isPresent()) {
			return new ResponseEntity<>(personData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person persons) {
		try {
			Person _person= personRepository
					.save(new Person(persons.getName(), persons.getAddress(), persons.getPostcode(), persons.getAge(),persons.getJob(), persons.geteEmail(), persons.getePhoneno()));
			return new ResponseEntity<>(_person, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person p) {
		Optional<Person> PersonData = personRepository.findById(id);

		if (PersonData.isPresent()) {
			Person _person = PersonData.get();
			_person.setName(p.getName());
			_person.setAddress(p.getAddress());
			_person.setPostcode(p.getPostcode());
			_person.setAge(p.getAge());
			_person.setJob(p.getJob());
			_person.setEmail(p.geteEmail());
			_person.setPhoneno(p.getePhoneno());
			return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			personRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
