package com.project.sharehouse.dto;

import com.project.sharehouse.domain.common.Address;
import com.project.sharehouse.domain.common.BuildingType;
import com.project.sharehouse.domain.common.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HouseDTO {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED) //역직렬화를 위한 생성자. protected로 설정하여 개발자가 객체 생성 못하게 설정
    public static class CreateReq {

        @NotBlank
        private String name; //하우스 이름

        @NotNull
        //TODO. enum타입 직렬화/역직렬화 고려해야 함
        private Gender acceptedGender; //수용가능 성별

        //TODO. embedded타입 DTO에 사용할지 말지 고려
        private Address address; //주소

        @NotNull
        private BuildingType buildingType; //건물형태

        @NotNull @Size(max = 99_999_999)
        private Integer deposit; //보증금

        @NotNull @Size(max = 9_999_999)
        private Integer maintenancefee; //관리비

        @NotNull @Size(max = 100)
        private Integer capacity; //수용인원

        private String description; //하우스 설명
    }


}
