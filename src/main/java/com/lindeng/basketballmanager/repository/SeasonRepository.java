package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.Season;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<Season, Integer> {
}