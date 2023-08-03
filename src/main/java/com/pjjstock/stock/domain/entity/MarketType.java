package com.pjjstock.stock.domain.entity;

import lombok.Getter;

@Getter
public enum MarketType {
    KOSPI("KOSPI"),
    KOSDAC("KOSDAC")
    ;

    private final String value;

    MarketType(String value) {
        this.value = value;
    }
}
