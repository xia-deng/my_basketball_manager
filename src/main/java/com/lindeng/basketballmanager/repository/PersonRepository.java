package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.dto.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}