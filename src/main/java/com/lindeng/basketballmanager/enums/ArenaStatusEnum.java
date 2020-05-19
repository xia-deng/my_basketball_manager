package com.lindeng.basketballmanager.enums;

public enum ArenaStatusEnum {

    BOUGHT("已拥有"),
    LEASE("租赁");

    private String description;

    ArenaStatusEnum(String description) {
        this.description = description;
    }
}
