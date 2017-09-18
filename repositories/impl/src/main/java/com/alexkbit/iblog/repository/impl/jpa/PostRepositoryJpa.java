package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link PostEntity}
 */
public interface PostRepositoryJpa extends JpaRepository<PostEntity, String> {

    /**
     * Find all on page and order by createDate
     * @param pageable pageable
     * @return page
     */
    Page<PostEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
