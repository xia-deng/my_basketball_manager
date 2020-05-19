package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 事件，各种事件，针对对人员的各种事件
 */
@Table
@Entity(name = "event")
@Getter
@Setter
@ToString
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @Column(name = "event_description", length = 512)
    private String eventDescription;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
    @JoinTable(name = "event_person", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    private Set<Person> personSet;
}
