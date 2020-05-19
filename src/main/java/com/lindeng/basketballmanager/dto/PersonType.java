package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 人员类型
 */
@Table
@Entity(name = "person_type")
@Getter
@Setter
@ToString
public class PersonType {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @OneToMany(mappedBy = "personType")
    private Set<Person> personSet;

    public PersonType(String name) {
        this.name = name;
    }
}
