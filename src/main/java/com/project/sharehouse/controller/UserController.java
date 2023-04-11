package com.project.sharehouse.controller;

import com.project.sharehouse.dto.UserRequestDTO;
import com.project.sharehouse.exception.BizException;
import com.project.sharehouse.exception.ErrorCode;
import com.project.sharehouse.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        if (!userRequestDTO.getPassword().equals(userRequestDTO.getCheckPassword())) {
            throw new BizException("패스워드 확인값이 일치하지 않습니다.", ErrorCode.INPUT_VALUE_INVALID);
        }

        Long userId = userService.joinUser(userRequestDTO.toEntity());

        return ResponseEntity.ok()
                .body("성공");
    }
}
