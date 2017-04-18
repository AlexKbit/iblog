package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.Resume;

/**
 * Business repository fo {@link Resume}
 */
public interface ResumeRepository extends BaseRepository<Resume> {

    /**
     * Find resume by user id
     * @param userId id of user
     * @return resume
     */
    Resume getByUserId(String userId);
}
