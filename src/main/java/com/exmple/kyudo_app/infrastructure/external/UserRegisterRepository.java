package com.exmple.kyudo_app.infrastructure.external;


import com.exmple.kyudo_app.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterRepository extends JpaRepository<User, Long> {
}

