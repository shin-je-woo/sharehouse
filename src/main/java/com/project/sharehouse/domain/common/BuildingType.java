package com.project.sharehouse.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BuildingType {

    MONO("단독주택"),
    MULTI("다세대주택"),
    APT("아파트"),
    ETC("기타");

    private final String value;
}
