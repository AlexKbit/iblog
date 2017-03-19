package com.alexkbit.iblog.repository.impl.jpa;

import com.alexkbit.iblog.repository.impl.entities.ImageEntity;
import com.alexkbit.iblog.repository.impl.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring data repository for {@link UserEntity}
 */
public interface ImageRepositoryJpa extends JpaRepository<ImageEntity, String> {

    @Query("select i from ImageEntity i where i.user.id =:userId")
    Page<ImageEntity> findByUserId(@Param("userId") String userId, Pageable pageable);

}
