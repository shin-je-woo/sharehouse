package com.project.sharehouse.domain;

import com.project.sharehouse.domain.common.Address;
import com.project.sharehouse.domain.common.Gender;
import com.project.sharehouse.domain.common.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id; // primary key

    private String name; //이름(실명)

    private String userName; //아이디

    private String password; // 비밀번호

    private String phoneNumber; // 폰번호

    @Enumerated(EnumType.STRING)
    private Gender gender; // 성별 [ MALE, FEMAILE ]

    @Enumerated(EnumType.STRING)
    private UserRole userRole; //권한 [ USER, ADMIN, SUPERVISOR ]

    @Embedded
    private Address address; // 주소

}
