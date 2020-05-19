package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League, Integer> {
}