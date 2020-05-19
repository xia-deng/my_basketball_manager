package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.dto.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League, Integer> {
}