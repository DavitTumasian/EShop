package com.example.eshop.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private UserEntity user;

    public CurrentUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public Long getId(){
    return user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                '}';
    }
}


