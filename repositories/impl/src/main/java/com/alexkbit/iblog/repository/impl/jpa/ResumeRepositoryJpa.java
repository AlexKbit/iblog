package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Spring data repository for {@link ResumeEntity}
 */
public interface ResumeRepositoryJpa extends JpaRepository<ResumeEntity, String> {

    /**
     * Find active resume
     * @return resume
     */
    @Query("select r from ResumeEntity r where r.active = true")
    ResumeEntity findActive();

}
