package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import com.alexkbit.iblog.repository.impl.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Implementation of {@link UserRepository}
 */
@Repository
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
    protected UserEntity findById(String uuid) {
        return userRepositoryJpa.findOne(uuid);
    }

    @Override
    protected void deleteById(String id) {
        userRepositoryJpa.delete(id);
    }

    @Override
    public User findByLogin(String login) {
        UserEntity entity = userRepositoryJpa.findByLogin(login);
        if (entity == null) {
            return null;
        }
        return mapToModel(entity);
    }
}
