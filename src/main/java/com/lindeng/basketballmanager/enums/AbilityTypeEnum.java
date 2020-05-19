package com.lindeng.basketballmanager.enums;

public enum AbilityTypeEnum {
    //--------------------------------Common
    OFFENSIVE("进攻"),
    DEPLOY("防守"),

    //--------------------------------Player
    BODY("身体"),
    FILL_BALL("球感"),
    MOOD("情绪"),

    //--------------------------------Worker
    TACTICAL("战术训练"),
    FITNESS("身体训练"),
    LEAD("领导力"),
    SCOUT("球探"),
    MEDICAL("医疗");

    private String description;

    AbilityTypeEnum(String description) {
        this.description = description;
    }
}
