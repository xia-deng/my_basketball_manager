package com.lindeng.basketballmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 合同，一个球员只有一个合同，一个合同可以同时属于多个球员
 */
@Table
@Entity(name = "contract")
@Getter
@Setter
@ToString
public class Contract {

    @Id
    @GeneratedValue
    private int id;

    /**
     * 合同名称
     */
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    /**
     * 合同金额
     */
    @Column
    private int salary;

    /**
     * 合同长度
     */
    @Column
    private int years;

    /**
     * 合同级别
     */
    @Column
    private int level;

    /**
     * 合同最低金额
     */
    @Column(name = "min_salary")
    private int minSalary;

    /**
     * 合同最高金额
     */
    @Column(name = "max_salary")
    private int maxSalary;

    /**
     * MVP奖励
     */
    @Column(name = "mvp_bonus")
    private int mvpBonus;

    /**
     * 最佳防守奖励
     */
    @Column(name = "deploy_bonus")
    private int deployBonus;

    /**
     * FMVP奖励
     */
    @Column(name = "fmvp_bonus")
    private int fmvpBonus;

    /**
     * 球队名次奖励
     */
    @Column(name = "rank_bonus", length = 256)
    private String rankBonus;

    /**
     * 是否允许选秀
     */
    @Column(name = "draft_enable")
    private boolean draftEnable;

    /**
     * 转会费
     */
    @Column(name = "transfer_fee")
    private int transferFee;

    /**
     * 转会费抽取比例
     */
    @Column(name = "transfer_fee_percent")
    private double transferFeePercent;

    /**
     * 选秀抽取比例
     */
    @Column(name = "draft_percent")
    private double draftPercent;

    @OneToMany(mappedBy = "personContract")
    private Set<Person> personSet;

    /**
     * 其他奖励金额
     */
    @Column(name = "other_bonus")
    private int otherBonus;

    /**合同类型*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_type")
    private ContractType contractType;
}
