package com.project.sharehouse.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class RoomDTO {

    @NotBlank
    private String name; //방 이름

    private String description; //방 설명
}
