package com.project.sharehouse.domain;

import com.project.sharehouse.domain.common.Address;
import com.project.sharehouse.domain.common.BuildingType;
import com.project.sharehouse.domain.common.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class House {

    @Id
    @GeneratedValue
    @Column(name = "house_id")
    private Long id;

    @Column(name = "house_name")
    private String name; //하우스 이름

    @Enumerated(EnumType.STRING)
    private Gender acceptedGender; //수용가능 성별

    @Embedded
    private Address address; //주소

    @Enumerated(EnumType.STRING)
    private BuildingType buildingType; //건물형태

    private Integer deposit; //보증금

    private Integer maintenancefee; //관리비

    private Integer capacity; //수용인원

    private String description; //하우스 설명

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
    private List<HouseDetail> houseDetails = new ArrayList<>();

    @Builder
    public House(String name, Gender acceptedGender, Address address, BuildingType buildingType, Integer deposit, Integer maintenancefee, Integer capacity, String description) {
        this.name = name;
        this.acceptedGender = acceptedGender;
        this.address = address;
        this.buildingType = buildingType;
        this.deposit = deposit;
        this.maintenancefee = maintenancefee;
        this.capacity = capacity;
        this.description = description;
    }

    //==연관관계 메서드==//
    public void addRoom(Room room) {
        rooms.add(room);
        room.setHouse(this);
    }
}
