package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 各种记录相关联的信息
 */
@Table
@Entity(name = "some_records")
@Getter
@Setter
@ToString
public class SomeoneRecords {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "record_id")
    private int recordId;

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "season_id")
    private int seasonId;

    @Column(name = "leagueId")
    private int leagueId;
}
