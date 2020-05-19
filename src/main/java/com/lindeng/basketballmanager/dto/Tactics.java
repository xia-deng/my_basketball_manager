package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 战术信息
 */
@Table
@Getter
@Setter
@ToString
@Entity(name = "tactics")
public class Tactics {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 128)
    private String name;

    @Column(name = "effect_common")
    private double effectCommon;

    @Column(length = 256)
    private String description;


}
