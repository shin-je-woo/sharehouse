package com.project.sharehouse.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성"),
    BOTH("혼용");

    private final String value;
}
