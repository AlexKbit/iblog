package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Business service for {@link User}
 */
public interface UserService extends UserDetailsService {

    /**
     * Save user
     * @param user user
     * @return user
     */
    User save(User user);

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

    /**
     * Get user by email
     * @param email email
     * @return {@link User}
     */
    User getByEmail(String email);

    /**
     * Get user by login
     * @param login login
     * @return {@link User}
     */
    User getByLogin(String login);

    /**
     * Gets page of users
     * @param page number of page
     * @param count count of users
     * @return page
     */
    ModelPage<User> get(int page, int count);

    /**
     * Change value of enabled
     * @param userId id of user
     * @param enabled value for enabled
     */
    void enableUser(String userId, boolean enabled);

    /**
     * Change avatar for user
     * @param userId id of user
     * @param image avatar
     */
    void changeAvatar(String userId, Image image);

}
