package com.project.sharehouse.service;

import com.project.sharehouse.domain.User;
import com.project.sharehouse.exception.BizException;
import com.project.sharehouse.exception.ErrorCode;
import com.project.sharehouse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long joinUser(User user) {
        getValidateDuplicateUser(user); //중복 회원 검증
        userRepository.save(user);
        return user.getId();
    }

    private void getValidateDuplicateUser(User user) {
        if (!userRepository.findByUserName(user.getUserName()).isEmpty()) {
            throw new BizException("중복된 회원ID가 존재합니다.", ErrorCode.EXIST_DUPL_VALUE);
        }
        if (!userRepository.findByPhoneNumber(user.getPhoneNumber()).isEmpty()) {
            throw new BizException("중복된 폰번호가 존재합니다.", ErrorCode.EXIST_DUPL_VALUE);
        }
    }
}
