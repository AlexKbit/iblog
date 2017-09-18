package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.Post;
import com.alexkbit.iblog.model.PostElementType;

/**
 * Business service for {@link Post}.
 */
public interface PostService {

    /**
     * Save post.
     * @param post post
     * @return new post
     */
    Post save(Post post);

    /**
     * Get post by id.
     * @param uuid UUID
     * @return {@link Post}
     */
    Post get(String uuid);

    /**
     * Delete post by id.
     * @param uuid UUID
     */
    void delete(String uuid);

    /**
     * Gets page of posts.
     * @param page number of page
     * @param count count of posts
     * @return page
     */
    PageModel<Post> get(int page, int count);

    /**
     * Create new element for post.
     * @param uuid id of post
     * @param type type of element
     * @return post
     */
    Post createNewElement(String uuid, PostElementType type);

    /**
     * Move current order up.
     * @param uuid id of post
     * @param currentOrder order to up.
     * @return post.
     */
    Post moveElementUp(String uuid, int currentOrder);

    /**
     * Move current order down.
     * @param uuid id of post
     * @param currentOrder order to up.
     * @return post.
     */
    Post moveElementDown(String uuid, int currentOrder);
}
