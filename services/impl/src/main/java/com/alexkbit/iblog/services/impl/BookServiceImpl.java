package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.repositories.api.BookRepository;
import com.alexkbit.iblog.servvices.api.BookService;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link ImageService}
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        if (book == null) {
            return null;
        }
        Book newBook = bookRepository.save(book);
        log.debug("Save new book with id = {}", newBook.getId());
        return newBook;
    }

    @Override
    public Book get(String uuid) {
        if (uuid == null) {
            return null;
        }
        log.debug("Load book by id = {}", uuid);
        return bookRepository.findOne(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (uuid == null) {
            return;
        }
        log.debug("Delete book with id = {}", uuid);
        bookRepository.delete(uuid);
    }

    @Override
    public PageModel<Book> get(int page, int count) {
        log.debug("Load page = {} with count = {} of books", page, count);
        return bookRepository.findAll(page, count);
    }
}
