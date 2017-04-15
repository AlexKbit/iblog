package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.model.User;

/**
 * Business repository fo {@link User}
 */
public interface UserRepository extends BaseRepository<User> {

    /**
     * Find user by login
     * @param login login
     * @return {@link User}
     */
    User findByLogin(String login);

    /**
     * Find user by email
     * @param email email
     * @return {@link User}
     */
    User findByEmail(String email);

    /**
     * Find user by email or login
     * @param loginOrEmail email or login
     * @return {@link User}
     */
    User findByLoginOrEmail(String loginOrEmail);

    /**
     * Find users
     * @param page page number
     * @param size count on page
     * @return page
     */
    ModelPage<User> findAll(int page, int size);
}
