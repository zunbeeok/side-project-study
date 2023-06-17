package com.sideproject.app.user;

import com.sideproject.app.domain.model.User;
import com.sideproject.app.domain.user.dto.request.UserCreateRequestDto;
import com.sideproject.app.domain.user.enums.Role;
import com.sideproject.app.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    UserService userService;

    public UserCreateRequestDto createUser(){
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto();
        userCreateRequestDto.setUserRole(Role.USER);
        userCreateRequestDto.setUserEmail("test@gmail.com");
        userCreateRequestDto.setUserName("최준홍");
        userCreateRequestDto.setUserNickName("test");
        userCreateRequestDto.setUserPassword("1234");
        userCreateRequestDto.setUserPhoneNumber("01022126825");
        return userCreateRequestDto;
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void joinUserTest(){
        UserCreateRequestDto user = createUser();
        User joinUser = userService.join(user);

        assertEquals(user.getUserEmail(), joinUser.getUserEmail());
        assertEquals(user.getUserName(), joinUser.getUserName());
        assertEquals(user.getUserRole(), joinUser.getUserRole());
        assertEquals(user.getUserPhoneNumber(), joinUser.getUserPhoneNumber());

        //비밀번호는 알고리즘으로 복호화 하기 때문에 증명이 되지 않는다.
    }
}
