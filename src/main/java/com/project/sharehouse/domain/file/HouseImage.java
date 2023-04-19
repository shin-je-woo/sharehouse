package com.project.sharehouse.domain.file;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue(value = "H")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseImage extends CmmFile {

    private String description;

    @Builder
    private HouseImage(String originalFileName, String savedFileName, String extension, Long size, String uploadDir, String description) {
        super(originalFileName, savedFileName, extension, size, uploadDir);
        this.description = description;
    }
}
