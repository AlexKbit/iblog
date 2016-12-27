package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import com.alexkbit.iblog.repository.impl.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link UserRepository}
 */
@Repository
@Transactional
public class UserRepositoryImpl extends AbstractBaseRepository<User, UserEntity> implements UserRepository {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    protected void saveEntity(UserEntity entity) {
        userRepositoryJpa.save(entity);
    }

    @Override
    protected void saveEntities(Collection<UserEntity> entities) {
        userRepositoryJpa.save(entities);
    }

    @Override
    protected UserEntity findById(UUID uuid) {
        return userRepositoryJpa.findOne(uuid);
    }

    @Override
    protected void deleteById(UUID id) {
        userRepositoryJpa.delete(id);
    }
}
