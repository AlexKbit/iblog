package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import com.alexkbit.iblog.repository.impl.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link UserRepository}.
 */
@Repository
public class UserRepositoryImpl extends AbstractBaseRepository<User, UserEntity> implements UserRepository {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    protected JpaRepository<UserEntity, String> getRepository() {
        return userRepositoryJpa;
    }

    @Override
    public User findByLogin(String login) {
        return findOne(() -> userRepositoryJpa.findByLogin(login));
    }

    @Override
    public User findByEmail(final String email) {
        return findOne(() -> userRepositoryJpa.findByEmail(email));
    }

    @Override
    public User findByLoginOrEmail(String loginOrEmail) {
        return findOne(() -> userRepositoryJpa.findByEmailOrLogin(loginOrEmail));
    }

    @Override
    public PageModel<User> findAll(int page, int size) {
        Page<UserEntity> result = userRepositoryJpa.findAllByOrderByCreatedAtDesc(new PageRequest(page, size));
        return mapToModel(result);
    }

}
