package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 人物有类型
 * personType记录人物类型
 * 人物有能力
 * ability记录人物能力
 * 人物有位置
 * position记录人物位置
 * 人物有战术影响
 */
@Table
@Entity(name = "person")
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Column(name = "country", nullable = true, length = 128)
    private String country;
    @Column(name = "shot_country_code", nullable = true, length = 8)
    private String shortCountryCode;
    @Column(name = "province", nullable = true, length = 128)
    private String province;
    @Column(name = "city", nullable = true, length = 128)
    private String city;
    @Column(name = "university", nullable = true, length = 128)
    private String university;

    //技能列表——五维技能：进攻，防守，身体，球感，情绪
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "person_abilities", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"))
    private Set<Ability> abilities;

    //因为位置带来的能力影响
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "person_positions", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    private Set<Position> positions;

//    //因为战术带来的能力影响
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
//    @JoinTable(name = "tactics_person", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "tactics_id", referencedColumnName = "id"))
//    private Set<Tactics> tactics;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
//    @JoinTable(name = "person_status", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "status_id", referencedColumnName = "id"))
//    private Set<Status> statusPerson;

    @ManyToMany(mappedBy="personSet")
    private Set<Event> eventSet;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_team")
    private Team team;

    @Column(name = "famous_percent", nullable = false)
    private double famousPercent = 1d;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_type")
    private PersonType personType;

    @Column(length = 256)
    private String description;

    @Column
    private double height;

    @Column
    private int salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_contract")
    private Contract personContract;


    @Column
    private int age;

    @Column(name = "end_career")
    private boolean endCareer;

    @Column
    private int level;
}
