package com.alexkbit.iblog.repository.impl.jpa;

import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring data repository for {@link UserEntity}
 */
public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {

    /**
     * Find user by login
     * @param login login
     * @return user
     */
    UserEntity findByLogin(String login);

    /**
     * Find user by email
     * @param email email
     * @return user
     */
    UserEntity findByEmail(String email);

    /**
     * Find user by email or login
     * @param loginOrEmail login or email
     * @return user
     */
    @Query("select u from UserEntity u where u.email = :loginOrEmail or u.login = :loginOrEmail")
    UserEntity findByEmailOrLogin(@Param("loginOrEmail") String loginOrEmail);

    /**
     * Find all users and order by createdAt
     * @param pageable pageable
     * @return page
     */
    Page<UserEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);

}
