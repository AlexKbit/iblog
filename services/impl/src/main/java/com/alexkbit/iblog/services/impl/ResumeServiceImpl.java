package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Resume;
import com.alexkbit.iblog.repositories.api.ResumeRepository;
import com.alexkbit.iblog.servvices.api.ResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link ResumeService}
 */
@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    private static final Logger log = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume save(Resume resume) {
        Resume newResume = resumeRepository.save(resume);
        log.debug("Save resume with id = {}", newResume.getId());
        return newResume;
    }

    @Override
    public Resume get(String id) {
        log.debug("Get resume by id = {}", id);
        return resumeRepository.findOne(id);
    }

    @Override
    public Resume getByUser(String userId) {
        return resumeRepository.getByUserId(userId);
    }
}
