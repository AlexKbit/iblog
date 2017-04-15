package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link BookEntity}
 */
public interface BookRepositoryJpa extends JpaRepository<BookEntity, String> {

    /**
     * Find all on page and order by endDate
     * @param pageable pageable
     * @return page
     */
    Page<BookEntity> findAllByOrderByEndDateDesc(Pageable pageable);
}
