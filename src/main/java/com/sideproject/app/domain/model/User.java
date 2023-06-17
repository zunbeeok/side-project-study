package com.sideproject.app.domain.model;

import com.sideproject.app.common.BaseTimeEntity;
import com.sideproject.app.domain.user.enums.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    private String userName;

    private String userNickName;

    @Column(unique = true)
    private String userEmail;

    private String userPassword;

    private String userPhoneNumber;

    @Builder
    public User(Role userRole, String userName, String userNickName, String userEmail, String userPassword, String  userPhoneNumber){
        this.userRole = userRole;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
    }

}
