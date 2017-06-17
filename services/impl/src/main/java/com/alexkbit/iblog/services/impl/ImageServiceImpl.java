package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.repositories.api.ImageRepository;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link ImageService}
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private static final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image save(Image image) {
        if (image == null) {
            return null;
        }
        Image newImage = imageRepository.save(image);
        log.debug("Save new image with id = {}", newImage.getId());
        return newImage;
    }

    @Override
    public Image get(String id) {
        if (id == null) {
            return null;
        }
        log.debug("Load image by id = {}", id);
        return imageRepository.findOne(id);
    }

    @Override
    public PageModel<Image> getByUser(String userId, int page, int count) {
        log.debug("Load images by user {} page = {} count = {}", userId, page, count);
        return imageRepository.findByUserId(userId, page, count);
    }
}
