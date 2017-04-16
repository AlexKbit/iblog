package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Resume;
import com.alexkbit.iblog.servvices.api.ResumeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link ResumeService}
 */
@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Override
    public Resume save(Resume resume) {
        return null; //TODO
    }

    @Override
    public Resume get(String id) {
        return null; //TODO
    }

    @Override
    public Resume getByUser(String userId) {
        return null; //TODO
    }
}
