package com.project.sharehouse.domain;

import com.project.sharehouse.domain.common.DetailType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseDetail {

    @Id
    @GeneratedValue
    @Column(name = "house_detail_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DetailType detailType;

    private String description;

    @Builder
    public HouseDetail(DetailType detailType, String description) {
        this.detailType = detailType;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}
