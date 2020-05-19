package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "person_status")
@Getter
@Setter
@ToString
public class PersonStatus {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "effect_percent")
    private double effectPercent;

    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;

    @Column
    private boolean enable;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
