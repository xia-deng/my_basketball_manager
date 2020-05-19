package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 合同，合同的签订者信息
 */
@Table
@Entity(name = "contract_ends")
@Getter
@Setter
@ToString
public class ContractEnds {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Sponsor sponsor;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
