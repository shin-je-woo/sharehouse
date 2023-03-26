package com.project.sharehouse.domain;

import com.project.sharehouse.domain.common.Gender;
import com.project.sharehouse.domain.common.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id; // primary key

    private String name; //이름(실명)

    private String userName; //아이디

    private String password; //비밀번호

    private String phoneNumber; //폰번호

    private String address; //주소

    @Enumerated(EnumType.STRING)
    private Gender gender; //성별 [ MALE, FEMAILE ]

    @Enumerated(EnumType.STRING)
    private UserRole userRole; //권한 [ USER, ADMIN, SUPERVISOR ]

    @Builder
    public User(Long id, String name, String userName, String password, String phoneNumber, Gender gender, UserRole userRole, String address) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.userRole = userRole;
        this.address = address;
    }
}
