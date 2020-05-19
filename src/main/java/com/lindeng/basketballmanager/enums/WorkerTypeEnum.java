package com.lindeng.basketballmanager.enums;

public enum WorkerTypeEnum {
    MANAGER("经理"),
    COACH("主教练"),
    TACTICAL_COACH("战术教练"),
    FITNESS_COACH("身体教练"),
    PLAYERS_COACH("球员教练"),
    OFFENSIVE_COACH("进攻教练"),
    DEPLOY_COACH("防守教练"),
    SCOUT("球探"),
    TEAM_DOCTOR("队医");

    private String description;

    WorkerTypeEnum(String description) {
        this.description = description;
    }
}
