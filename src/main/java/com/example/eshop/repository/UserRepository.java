package com.example.eshop.repository;

import com.example.eshop.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    UserEntity findUserEntitiesByUsername (String username);

}
