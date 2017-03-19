package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.repositories.api.ImageRepository;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link ImageService}
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Image get(String id) {
        return imageRepository.findOne(id);
    }

    @Override
    public ModelPage<Image> getByUser(String userId, int page, int count) {
        return imageRepository.findByUserId(userId, page, count);
    }
}
