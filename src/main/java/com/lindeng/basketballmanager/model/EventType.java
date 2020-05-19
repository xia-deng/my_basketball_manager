package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "event_type")
@Getter
@Setter
@ToString
public class EventType {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(length = 256)
    private String description;

    @OneToMany(mappedBy = "eventType")
    private Set<Event> events;

    public EventType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
