package com.exmple.kyudo_app.domain.service;

import com.exmple.kyudo_app.domain.model.User;
import com.exmple.kyudo_app.infrastructure.external.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegisterService {

    private final UserRegisterRepository userRegisterRepository;

    @Autowired
    public UserRegisterService(UserRegisterRepository userRegisterRepository){
        this.userRegisterRepository = userRegisterRepository;
    }

@Transactional
    public User registryUser(User user){
        return userRegisterRepository.save(user);
}

@Transactional
    public User getUserById(Long id){
        return userRegisterRepository.getReferenceById(id);
}
}
