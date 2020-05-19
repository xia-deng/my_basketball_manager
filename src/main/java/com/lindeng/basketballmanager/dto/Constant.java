package com.lindeng.basketballmanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity(name = "constant")
@Getter
@Setter
@ToString
public class Constant {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Column(length = 16)
    private String type;
    @Column(length = 256)
    private String content;
}
