package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}