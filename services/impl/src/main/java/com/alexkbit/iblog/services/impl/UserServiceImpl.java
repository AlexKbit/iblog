package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.servvices.api.UserService;
import com.alexkbit.iblog.servvices.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of service for {@link User}
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if (user == null) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User register(User user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            String errorMsg = String.format("User with login: %s already exist.", user.getLogin());
            log.error(errorMsg);
            throw new ServiceException(errorMsg);
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            String errorMsg = String.format("User with email: %s already exist.", user.getEmail());
            log.error(errorMsg);
            throw new ServiceException(errorMsg);
        }
        log.info("Register new user with login = {}", user.getLogin());
        return userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        if (uuid == null) {
            return null;
        }
        log.info("Load user by id = {}", uuid);
        return userRepository.findOne(uuid);
    }

    @Override
    public User getByEmail(String email) {
        if (email == null) {
            return null;
        }
        log.info("Load user by email = {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByLogin(String login) {
        if (login == null) {
            return null;
        }
        log.info("Load user by login = {}", login);
        return userRepository.findByLogin(login);
    }

    @Override
    public ModelPage<User> get(int page, int count) {
        log.info("Load page = {} with count = {} of users", page, count);
        return userRepository.findAll(page, count);
    }

    @Override
    public void enableUser(String userId, boolean enabled) {
        log.info("Set enabled = {} for user with id = {}", enabled, userId);
        User user = userRepository.findOne(userId);
        if (user == null) {
            log.info("User with id = {} not found", userId);
            return;
        }
        user.setEnabled(enabled);
        userRepository.save(user);
    }

    @Override
    public void changeAvatar(String userId, Image image) {
        if (userId == null || image == null) {
            return;
        }
        User user = this.get(userId);
        log.info("Set new avatar {} for user {}", image.getId(), userId);
        user.setAvatar(image);
        userRepository.save(user);
    }

    @Override
    public CurrentUser loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByLoginOrEmail(loginOrEmail);
        if (user == null) {
            String errorMsg = String.format("User with %s was not found", loginOrEmail);
            log.error(errorMsg);
            throw new UsernameNotFoundException(errorMsg);
        }
        log.info("Load user by username = {}", loginOrEmail);
        return new CurrentUser(user);
    }
}
