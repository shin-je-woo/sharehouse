package com.project.sharehouse.dto;

import com.project.sharehouse.domain.User;
import com.project.sharehouse.domain.common.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class UserRequestDTO {

    @NotBlank
    private String name; //이름(실명)

    @NotBlank
    private String userName; //아이디

    @NotBlank
    private String password; //비밀번호

    @NotBlank
    private String checkPassword; //비밀번호 확인

    @NotBlank
    private String phoneNumber; //폰번호

    @NotNull
    private Gender gender; //성별 [ MALE, FEMAILE ]

    private String address; //주소

    public User toEntity() {
        return User.builder()
                .name(name)
                .userName(userName)
                .password(password)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .address(address)
                .build();
    }
}
