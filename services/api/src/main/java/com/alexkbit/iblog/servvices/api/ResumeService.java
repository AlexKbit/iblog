package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Resume;

/**
 * Service for resume
 */
public interface ResumeService {

    /**
     * Save resume
     * @param resume resume
     * @return new resume
     */
    Resume save(Resume resume);

    /**
     * Get resume by id
     * @param id id
     * @return {@link Resume}
     */
    Resume get(String id);

    /**
     * Get resume by user id
     * @param userId id of user
     * @return {@link Resume}
     */
    Resume getByUser(String userId);
}
