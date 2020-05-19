package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}