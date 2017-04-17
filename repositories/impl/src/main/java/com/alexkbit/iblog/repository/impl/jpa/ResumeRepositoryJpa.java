package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link ResumeEntity}
 */
public interface ResumeRepositoryJpa extends JpaRepository<ResumeEntity, String> {

}
