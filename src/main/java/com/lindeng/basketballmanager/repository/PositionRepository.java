package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.dto.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}