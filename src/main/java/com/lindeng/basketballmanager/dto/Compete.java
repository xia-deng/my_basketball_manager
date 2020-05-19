package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 比赛信息表
 */
@Table
@Entity(name = "compete")
@Getter
@Setter
@ToString
public class Compete {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 128)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compete_season")
    private Season season;

    @Column(length = 128)
    private String result;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "compete_teams", joinColumns = @JoinColumn(name = "compete_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    private Set<Team> teams;
}
