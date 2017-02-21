package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.servvices.api.UserService;
import com.alexkbit.iblog.servvices.api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of service for {@link User}
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new ServiceException(String.format("User with login: %s already exist.", user.getLogin()));
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ServiceException(String.format("User with email: %s already exist.", user.getEmail()));
        }
        return userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        if (uuid == null) {
            return null;
        }
        return userRepository.findOne(uuid);
    }

    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByLoginOrEmail(loginOrEmail);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with %s was not found", loginOrEmail));
        }
        return user;
    }
}
