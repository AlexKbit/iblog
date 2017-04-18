package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.ImageEntity;
import com.alexkbit.iblog.repository.impl.entities.ResumeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring data repository for {@link ResumeEntity}
 */
public interface ResumeRepositoryJpa extends JpaRepository<ResumeEntity, String> {

    /**
     * Find resume by user id
     * @param userId id of user
     * @return resume
     */
    @Query("select r from ResumeEntity r where r.user.id =:userId")
    ResumeEntity findByUserId(@Param("userId") String userId);

}
