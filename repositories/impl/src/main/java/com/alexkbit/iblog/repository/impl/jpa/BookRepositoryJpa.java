package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link BookEntity}
 */
public interface BookRepositoryJpa extends JpaRepository<BookEntity, String> {
}
