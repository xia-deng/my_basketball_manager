package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 球队资金事件表
 */
@Table
@Getter
@ToString
@Setter
@Entity(name = "assert_event")
public class AssertEvent {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "event_name",length = 128)
    private String eventName;

    @Column(name = "event_content", length = 512)
    private String eventContent;

    /**
     * 事件带来的资金变化
     */
    @Column(name = "change_assert")
    private int changeAssert;

    /**
     * 事件的级别
     */
    @Column
    private int order;

    @ManyToMany(mappedBy="assertEventSet")
    private Set<TeamAssert> teamAssertSet;
}
