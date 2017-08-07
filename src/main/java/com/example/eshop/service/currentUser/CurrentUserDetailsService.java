package com.example.eshop.service.currentUser;

import com.example.eshop.model.CurrentUser;
import com.example.eshop.model.UserEntity;
import com.example.eshop.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityService userEntityService;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntityService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        } else {
            return new CurrentUser(user);
        }

    }
}
