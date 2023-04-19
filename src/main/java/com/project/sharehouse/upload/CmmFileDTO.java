package com.project.sharehouse.upload;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CmmFileDTO {

    private String originalFileName; //원본파일명

    private String savedFileName; //저장된파일명

    private String extension; //확장자

    private Long size; //파일사이즈

    private String uploadDir; //업로드경로

    @Builder
    public CmmFileDTO(String originalFileName, String savedFileName, String extension, Long size, String uploadDir) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.extension = extension;
        this.size = size;
        this.uploadDir = uploadDir;
    }
}
