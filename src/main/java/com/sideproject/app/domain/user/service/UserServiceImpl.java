package com.sideproject.app.domain.user.service;

import com.sideproject.app.domain.model.User;
import com.sideproject.app.domain.user.dto.request.UserCreateRequestDto;
import com.sideproject.app.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;

    private  final PasswordEncoder passwordEncoder;

    @Override
    public User join(UserCreateRequestDto userCreateRequestDto) {
        //중복회원 조회
        validateDuplicateUser(userCreateRequestDto.getUserEmail());
        //Entity 변환
        User user = userCreateRequestDto.toEntity(passwordEncoder);

        return userRepository.save(user);
    }

    @Override
    public void validateDuplicateUser(String userEmail) {
        User findUser = userRepository.findByUserEmail(userEmail);
        if( findUser != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmail(userEmail);

        if(user == null){
            throw  new UsernameNotFoundException(userEmail);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserEmail())
                .password(user.getUserPassword())
                .roles(user.getUserRole().toString())
                .build();
    }
}
