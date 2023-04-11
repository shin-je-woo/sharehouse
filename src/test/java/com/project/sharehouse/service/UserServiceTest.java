package com.project.sharehouse.service;

import com.project.sharehouse.repository.UserRepository;
import com.project.sharehouse.domain.User;
import com.project.sharehouse.domain.common.Gender;
import com.project.sharehouse.dto.UserRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EntityManager em;

    @Test
    void 회원가입() throws Exception {
        //given
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserName("shin.jewoo");
        userRequestDTO.setName("신제우");
        userRequestDTO.setPhoneNumber("01012345678");
        userRequestDTO.setGender(Gender.MALE);
        userRequestDTO.setPassword("test");

        User user = userRequestDTO.toEntity();

        //when
        Long savedId = userService.joinUser(user);

        //then
        Assertions.assertThat(user.getId()).isEqualTo(savedId);
    }

}