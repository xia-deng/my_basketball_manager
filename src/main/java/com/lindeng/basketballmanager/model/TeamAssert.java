package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 球队资产变化表
 */
@Table
@Getter
@ToString
@Setter
@Entity(name = "team_assert")
public class TeamAssert {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_assert_season")
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_team_assert")
    private Team team;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "team_assert_event", joinColumns = @JoinColumn(name = "team_assert_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assert_event_id", referencedColumnName = "id"))
    private Set<AssertEvent> assertEventSet;

}
