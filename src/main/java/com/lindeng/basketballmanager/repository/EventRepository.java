package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.dto.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}