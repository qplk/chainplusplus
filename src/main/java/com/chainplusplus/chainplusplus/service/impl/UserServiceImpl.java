package com.chainplusplus.chainplusplus.service.impl;

import com.chainplusplus.chainplusplus.model.User;
import com.chainplusplus.chainplusplus.repository.UserRepository;
import com.chainplusplus.chainplusplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {

        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        return userRepository.save(user);
    }
}
