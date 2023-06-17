package com.sideproject.app.domain.user.controller;

import com.sideproject.app.domain.user.dto.request.UserCreateRequestDto;
import com.sideproject.app.domain.user.enums.Role;
import com.sideproject.app.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String login(){
        return "success";
    }

    @GetMapping(value = "/login/error")
    public String loginError(){
        return "아이디 또는 비밀번호를 확인해주세요.";
    }

    @PostMapping(value = "/new")
    public String createUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto){
        userCreateRequestDto.setUserRole(Role.USER);
        try {
            userService.join(userCreateRequestDto);
        }catch (IllegalStateException e){
            return "fail";
        }
        return "success";
    }
}
