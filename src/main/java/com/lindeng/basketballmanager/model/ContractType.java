package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "contract_type")
@Getter
@Setter
@ToString
public class ContractType {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @OneToMany(mappedBy = "contractType")
    private Set<Contract> contractSet;
}
