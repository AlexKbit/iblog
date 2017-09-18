package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.Post;

/**
 * Business repository fo {@link Post}.
 */
public interface PostRepository extends BaseRepository<Post> {

    /**
     * Find posts.
     * @param page page number
     * @param size count on page
     * @return page
     */
    PageModel<Post> findAll(int page, int size);
}
