package com.sideproject.app.domain.user.service;

import com.sideproject.app.domain.model.User;
import com.sideproject.app.domain.user.dto.request.UserCreateRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    //회원가입
    public User join(UserCreateRequestDto userCreateRequestDto);

    public void validateDuplicateUser(String userEmail);


//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
