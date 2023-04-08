package com.project.sharehouse.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_name")
    private String name; //방 이름

    private String description; //방 설명

    @Setter
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @Builder
    public Room(String name, String description, House house) {
        this.name = name;
        this.description = description;
        this.house = house;
    }
}
