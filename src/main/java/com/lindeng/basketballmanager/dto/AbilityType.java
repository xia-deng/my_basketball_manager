package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**能力类型表*/
@Table
@Entity(name = "ability_type")
@Getter
@Setter
@ToString
public class AbilityType {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @OneToMany(mappedBy = "abilityType")
    private Set<Ability> abilitySet;
}
