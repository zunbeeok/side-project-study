package com.sideproject.app.domain.user.dto.request;

import com.sideproject.app.domain.model.User;
import com.sideproject.app.domain.user.enums.Role;
import  org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserCreateRequestDto {
    private Role userRole;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String userNickName;

    @Email(message = "이메일 형식이 아닙니다")
    private String userEmail;

    @NotEmpty
    private String userPassword;

    @NotEmpty
    private String userPhoneNumber;

    public User toEntity(PasswordEncoder passwordEncoder){
        return  User.builder()
                .userRole(userRole)
                .userName(userName)
                .userNickName(userNickName)
                .userEmail(userEmail)
                .userPassword(passwordEncoder.encode(userPassword))
                .userPhoneNumber(userPhoneNumber)
                .build();
    }
}
