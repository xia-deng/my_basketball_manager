package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.BooleanUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * 球馆信息表
 */
@Table
@Entity(name = "arena")
@Getter
@Setter
@ToString
public class Arena {

    @Id
    @GeneratedValue
    private int id;

    /**
     * 球馆名称
     */
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

    /**
     * 球馆座位数
     */
    @Column
    private int seats;

    /**
     * 球馆的影响程度，主要是影响票价
     */
    @Column
    private double effect;

    /**
     * 是否有中央空调
     */
    @Column(name = "center_air_condition")
    private boolean centerAirCondition = false;//是否有中央空调

    /**
     * 是否有中央转播电视
     */
    @Column(name = "center_tv")
    private boolean centerTV = false; //是否有中央转播电视

    /**
     * 球馆的级别，由以上几个boolean计算出来
     */
    @Column
    private int level;

    /**
     * 是否有独立训练场
     */
    @Column(name = "training_center")
    private boolean trainingCenter = false; // 是否有独立的训练场

    /**
     * 是否有主队独立更衣室
     */
    @Column(name = "locker_room")
    private boolean lockerRoom = true; //是否有独立更衣室

    /**
     * 是否有客队更衣室
     */
    @Column(name = "visitor_locker_room")
    private boolean visitorsLockerRoom = false; //是否有独立的客队更衣室

    /**
     * 球馆的状态
     */
    @Column(name = "arena_status", length = 16, nullable = false)
    private String arenaStatus;

    /**
     * 球馆属于哪个球队
     */
    @OneToMany(mappedBy = "arena")
    private Set<Team> teams;

    /**
     * 球馆的租金
     */
    @Column
    private BigDecimal rent; //租金

    /**
     * 球场的总价值
     */
    private BigDecimal worthValue;

    public int initLevel() {
        return BooleanUtils.toInteger(this.centerAirCondition) + BooleanUtils.toInteger(this.centerTV) + BooleanUtils.toInteger(this.lockerRoom)
                + BooleanUtils.toInteger(this.trainingCenter) + BooleanUtils.toInteger(this.visitorsLockerRoom);
    }
}
