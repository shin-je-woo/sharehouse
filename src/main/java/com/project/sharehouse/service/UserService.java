package com.project.sharehouse.service;

import com.project.sharehouse.Repository.UserRepository;
import com.project.sharehouse.domain.User;
import com.project.sharehouse.exception.DuplUserException;
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
            throw new DuplUserException("회원ID");
        }
        if (!userRepository.findByPhoneNumber(user.getPhoneNumber()).isEmpty()) {
            throw new DuplUserException("폰번호");
        }
    }
}
