package com.example.eshop.service;

import com.example.eshop.model.UserEntity;
import com.example.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    @Autowired
    UserRepository userRepository;

    public UserEntity getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntitiesByUsername(username);
        return userEntity;
    }

   public void saveNewUser(UserEntity userEntity) {
        userRepository.saveAndFlush(userEntity);
    }
}
