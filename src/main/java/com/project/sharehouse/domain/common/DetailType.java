package com.project.sharehouse.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetailType {

    OPTION("옵션"),
    RULE("규칙"),
    SERVICE("제공서비스"),
    ETC("기타");

    private final String value;
}
