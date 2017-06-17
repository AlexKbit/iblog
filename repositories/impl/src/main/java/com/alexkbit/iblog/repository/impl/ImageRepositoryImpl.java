package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.repositories.api.ImageRepository;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.repository.impl.entities.ImageEntity;
import com.alexkbit.iblog.repository.impl.jpa.ImageRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Implementation of {@link UserRepository}.
 */
@Repository
public class ImageRepositoryImpl extends AbstractBaseRepository<Image, ImageEntity> implements ImageRepository {

    @Autowired
    private ImageRepositoryJpa imageRepositoryJpa;

    @Override
    protected JpaRepository<ImageEntity, String> getRepository() {
        return imageRepositoryJpa;
    }

    @Override
    public PageModel<Image> findByUserId(String userId, int page, int size) {
        Page<ImageEntity> result = imageRepositoryJpa.findByUserId(userId, new PageRequest(page, size));
        return mapToModel(result);
    }
}
