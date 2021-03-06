package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.PageModel;

/**
 * Business repository fo {@link Image}.
 */
public interface ImageRepository extends BaseRepository<Image> {

    /**
     * Find image for user.
     * @param userId id of user
     * @param page page number
     * @param size count on page
     * @return page
     */
    PageModel<Image> findByUserId(String userId, int page, int size);
}
