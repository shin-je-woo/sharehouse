package com.project.sharehouse.domain.file;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue(value = "R")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomImage extends CmmFile {

    private String description;

    @Builder
    private RoomImage(String originalFileName, String savedFileName, String extension, String size, String uploadDir, String description) {
        super(originalFileName, savedFileName, extension, size, uploadDir);
        this.description = description;
    }
}
