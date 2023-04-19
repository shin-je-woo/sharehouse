package com.project.sharehouse.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
public class FileStore {

    //TODO.파일경로 수정 필요
    private final String filepath = "D:/file/";

    public CmmFileDTO storeFile(MultipartFile multipartFile, String uploadDir) {

        if (multipartFile.isEmpty()) {
            return null;
        }


        CmmFileDTO cmmFileDTO = makeCmmFileDTO(multipartFile);

        //TODO. 파일경로 File작성 필요

        return cmmFileDTO;
    }

    private CmmFileDTO makeCmmFileDTO(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = extractExtension(originalFilename);
        String savedFileName = uuid + "." + extension;
        long size = multipartFile.getSize();

        return CmmFileDTO.builder()
                .originalFileName(originalFilename)
                .savedFileName(savedFileName)
                .size(size)
                .extension(extension)
                .build();
    }

    private String extractExtension(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
