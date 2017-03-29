package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.Book;

/**
 * Business service for {@link Book}
 */
public interface BookService {

    Book save(Book book);
}
