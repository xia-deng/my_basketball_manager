package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 场上的位置信息
 */
@Table
@Entity(name = "position")
@Getter
@Setter
@ToString
public class Position {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "main_position")
    private boolean mainPosition;

    @ManyToMany(mappedBy="positions")
    private Set<Person> personSet;
}
