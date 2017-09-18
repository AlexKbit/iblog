package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.Post;
import com.alexkbit.iblog.repositories.api.PostRepository;
import com.alexkbit.iblog.repository.impl.entities.PostEntity;
import com.alexkbit.iblog.repository.impl.jpa.PostRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link PostRepository}.
 */
@Repository
public class PostRepositoryImpl extends AbstractBaseRepository<Post, PostEntity> implements PostRepository {

    @Autowired
    private PostRepositoryJpa postRepositoryJpa;

    @Override
    protected JpaRepository<PostEntity, String> getRepository() {
        return postRepositoryJpa;
    }

    @Override
    public PageModel<Post> findAll(int page, int size) {
        Page<PostEntity> result = postRepositoryJpa.findAllByOrderByCreatedAtDesc(new PageRequest(page, size));
        return mapToModel(result);
    }
}
