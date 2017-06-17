package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.PageModel;

/**
 * Business repository fo {@link Book}.
 */
public interface BookRepository extends BaseRepository<Book> {

    /**
     * Find books.
     * @param page page number
     * @param size count on page
     * @return page
     */
    PageModel<Book> findAll(int page, int size);

}
