package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.ModelPage;

/**
 * Business service for {@link Book}
 */
public interface BookService {

    /**
     * Save book
     * @param book book
     * @return new book
     */
    Book save(Book book);

    /**
     * Gets page of users
     * @param page number of page
     * @param count count of users
     * @return page
     */
    ModelPage<Book> get(int page, int count);
}
