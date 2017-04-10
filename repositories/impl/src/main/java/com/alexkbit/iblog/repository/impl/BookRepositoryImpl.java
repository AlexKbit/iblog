package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.repositories.api.BookRepository;
import com.alexkbit.iblog.repository.impl.entities.BookEntity;
import com.alexkbit.iblog.repository.impl.jpa.BookRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Implementation of {@link BookRepository}
 */
@Repository
public class BookRepositoryImpl extends AbstractBaseRepository<Book, BookEntity> implements BookRepository {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Override
    protected JpaRepository<BookEntity, String> getRepository() {
        return bookRepositoryJpa;
    }

    @Override
    public ModelPage<Book> findAll(int page, int size) {
        Page<BookEntity> result = bookRepositoryJpa.findAllByOrderByEndDateAsc(new PageRequest(page, size));
        return mapToModel(result);
    }
}
