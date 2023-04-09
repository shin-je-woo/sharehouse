package com.project.sharehouse.domain.file;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CmmFile {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String originalFileName; //원본파일명

    private String savedFileName; //저장된파일명

    private String extension; //확장자

    private String size; //파일사이즈

    private String uploadDir; //업로드경로

     protected CmmFile(String originalFileName, String savedFileName, String extension, String size, String uploadDir) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.extension = extension;
        this.size = size;
        this.uploadDir = uploadDir;
    }
}