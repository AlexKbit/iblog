package com.alexkbit.iblog.repository.impl.jpa;

import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link UserEntity}
 */
public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {

    UserEntity findByLogin(String login);

}
