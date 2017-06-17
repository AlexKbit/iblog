package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.PageModel;

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
     * Get book by id
     * @param uuid UUID
     * @return {@link Book}
     */
    Book get(String uuid);

    /**
     * Delete book by id
     * @param uuid UUID
     */
    void delete(String uuid);

    /**
     * Gets page of users
     * @param page number of page
     * @param count count of users
     * @return page
     */
    PageModel<Book> get(int page, int count);
}
