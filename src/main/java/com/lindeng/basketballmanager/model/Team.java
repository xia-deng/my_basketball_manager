package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * 球队信息
 */
@Table
@Getter
@ToString
@Setter
@Entity(name = "team")
public class Team {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 128)
    private String name;

    @Column(name = "team_created")
    private long teamCreated;

    @Column(name = "team_logo")
    private String teamLogo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arena")
    private Arena arena;

    @OneToMany(mappedBy = "team")
    private Set<Person> personSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_league")
    private League league;

    @OneToMany(mappedBy = "team")
    private Set<TeamAssert> teamAssertSet;

}
