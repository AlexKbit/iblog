package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.User;

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
     * @param uuid UUID
     * @return {@link User}
     */
    User get(String uuid);

}
