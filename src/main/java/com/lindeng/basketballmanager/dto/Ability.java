package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**能力信息表*/
@Table
@Entity(name = "ability")
@Getter
@Setter
@ToString
public class Ability {
    @Id
    @GeneratedValue
    private int id;

    /**能力名称*/
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    /**能力值*/
    @Column(name= "skill_number", nullable = false)
    private double skillNumber = 0;

    /**能力类型*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ability_type")
    private AbilityType abilityType;

    /**能力描述*/
    @Column(length = 256)
    private String description;

}
