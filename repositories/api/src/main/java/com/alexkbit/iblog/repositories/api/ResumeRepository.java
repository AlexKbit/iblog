package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.Resume;

/**
 * Business repository fo {@link Resume}.
 */
public interface ResumeRepository extends BaseRepository<Resume> {

    /**
     * Find active resume.
     * @return {@link Resume}
     */
    Resume findActive();
}
