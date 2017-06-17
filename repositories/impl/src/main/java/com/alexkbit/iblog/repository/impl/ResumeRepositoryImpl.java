package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.Resume;
import com.alexkbit.iblog.repositories.api.ResumeRepository;
import com.alexkbit.iblog.repository.impl.entities.ResumeEntity;
import com.alexkbit.iblog.repository.impl.jpa.ResumeRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Implementation of {@link ResumeRepository}.
 */
@Repository
public class ResumeRepositoryImpl extends AbstractBaseRepository<Resume, ResumeEntity> implements ResumeRepository {

    @Autowired
    private ResumeRepositoryJpa resumeRepositoryJpa;

    @Override
    protected JpaRepository<ResumeEntity, String> getRepository() {
        return resumeRepositoryJpa;
    }

    @Override
    public Resume getByUserId(String userId) {
        return mapToModel(resumeRepositoryJpa.findByUserId(userId));
    }
}
