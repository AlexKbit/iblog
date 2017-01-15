package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.services.impl.exception.ServiceException;
import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of service for {@link User}
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new ServiceException(String.format("User with login: %s already exist.", user.getLogin()));
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
}
