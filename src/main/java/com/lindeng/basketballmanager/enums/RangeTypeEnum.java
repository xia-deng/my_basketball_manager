package com.lindeng.basketballmanager.enums;

public enum  RangeTypeEnum {

    UNIVERSITY("校园风云人物"),
    CITY("城市英雄"),
    PROVINCE("名动全省"),
    COUNTRY("闻名全国"),
    COUNTRY_2("享誉全国"),
    WORLD("闻名世界"),
    WORLD_2("世界之巅");

    private String description;

    RangeTypeEnum(String description) {
        this.description = description;
    }
}
