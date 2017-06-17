package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.PageModel;

/**
 * Service for image
 */
public interface ImageService {

    /**
     * Save image
     * @param image image
     * @return new image
     */
    Image save(Image image);

    /**
     * Get image by id
     * @param id id of image
     * @return image
     */
    Image get(String id);

    /**
     * Get page of images by user id
     * @param userId id of user
     * @param page page number
     * @param count count on page
     * @return page
     */
    PageModel<Image> getByUser(String userId, int page, int count);
}
