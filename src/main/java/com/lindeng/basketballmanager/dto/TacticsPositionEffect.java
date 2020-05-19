package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity(name = "tactics_position")
@Getter
@Setter
@ToString
public class TacticsPositionEffect {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "effect_percent")
    private double effectPercent = 1;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "tactics_id")
    private Tactics tactics;
}
