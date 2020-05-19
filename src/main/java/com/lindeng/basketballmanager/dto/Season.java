package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 赛季信息
 */
@Table
@Entity(name = "season")
@Getter
@Setter
@ToString
public class Season {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(name = "start_time")
    private long startTime;

    @Column(name = "end_time")
    private long endTime;

    @OneToMany(mappedBy = "season")
    private Set<TeamAssert> teamAssertSet;
}
