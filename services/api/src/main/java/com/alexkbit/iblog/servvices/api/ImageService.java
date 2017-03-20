package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ModelPage;

/**
 * Created by aleksandrsavchenko on 19/03/2017.
 */
public interface ImageService {

    Image save(Image image);

    Image get(String id);

    ModelPage<Image> getByUser(String userId, int page, int count);
}
