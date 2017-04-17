package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.WorkPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link WorkPositionEntity}
 */
public interface WorkPositionRepositoryJpa extends JpaRepository<WorkPositionEntity, String> {

}
