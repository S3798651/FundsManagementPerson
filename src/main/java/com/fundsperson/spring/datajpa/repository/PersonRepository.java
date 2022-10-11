package com.fundsperson.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fundsperson.spring.datajpa.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
