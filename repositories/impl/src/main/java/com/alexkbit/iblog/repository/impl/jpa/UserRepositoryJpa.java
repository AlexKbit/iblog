package com.alexkbit.iblog.repository.impl.jpa;

import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Spring data repository for {@link UserEntity}
 */
public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

}
