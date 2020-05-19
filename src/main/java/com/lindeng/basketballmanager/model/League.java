package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 联赛信息
 */
@Table
@Entity(name = "league")
@Getter
@Setter
@ToString
public class League {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column
    private int level;

    @Column(name = "teams_number")
    private int teamsNumber;

    @Column(name = "rank_bonus", length = 256)
    private String rankBonus;

    @Column(name = "other_bonus")
    private int otherBonus;

    @Column(name = "mvp_bonus")
    private int mvpBonus;

    @Column(name = "deploy_bonus")
    private int deployBonus;

    @Column(name = "fmvp_bonus")
    private int fmvpBonus;

    @OneToMany(mappedBy = "league")
    private Set<Team> teams;
}
