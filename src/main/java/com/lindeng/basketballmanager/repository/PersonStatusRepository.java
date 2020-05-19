package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.PersonStatus;
import org.springframework.data.repository.CrudRepository;

public interface PersonStatusRepository extends CrudRepository<PersonStatus, Integer> {
}