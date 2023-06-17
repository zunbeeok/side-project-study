package com.sideproject.app.domain.user.repository;

import com.sideproject.app.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);
}
