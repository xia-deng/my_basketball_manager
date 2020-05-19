package com.lindeng.basketballmanager.repository;

import com.lindeng.basketballmanager.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Integer> {
}