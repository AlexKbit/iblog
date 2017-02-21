package com.alexkbit.iblog.repository.impl.jpa;

import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring data repository for {@link UserEntity}
 */
public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {

    UserEntity findByLogin(String login);

    UserEntity findByEmail(String email);

    @Query("select u from UserEntity u where u.email = :loginOrEmail or u.login = :loginOrEmail")
    UserEntity findByEmailOrLogin(@Param("loginOrEmail") String loginOrEmail);

}
