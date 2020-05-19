package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 赞助商信息
 */
@Table
@Entity(name = "sponsor")
@Getter
@Setter
@ToString
public class Sponsor {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
}
