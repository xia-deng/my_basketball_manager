package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Set;

/**
 * 各种记录
 */
@Table
@Entity(name = "records")
@Getter
@Setter
@ToString
public class Records {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "records_season")
    private Season season;

    @Column(length = 256)
    private String description;

}
