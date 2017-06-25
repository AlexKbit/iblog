package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Resume;

/**
 * Service for resume.
 */
public interface ResumeService {

    /**
     * Save resume.
     * @param resume resume
     * @return new resume
     */
    Resume save(Resume resume);

    /**
     * Get resume by id.
     * @param id id
     * @return {@link Resume}
     */
    Resume get(String id);

    /**
     * Get active resume.
     * @return {@link Resume}
     */
    Resume getActive();
}
