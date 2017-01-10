package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.User;

import java.util.UUID;

/**
 * Business service for {@link User}
 */
public interface UserService {

    /**
     * Register new user in system
     * @param user
     */
    User register(User user);

    /**
     * Get user by id
     * @param uuid {@link UUID}
     * @return {@link User}
     */
    User get(UUID uuid);

}
