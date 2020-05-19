package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity(name = "person_positions")
@Getter
@Setter
@ToString
public class PositionPersonEffect {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "effect_percent")
    private double effectPercent = 1;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
