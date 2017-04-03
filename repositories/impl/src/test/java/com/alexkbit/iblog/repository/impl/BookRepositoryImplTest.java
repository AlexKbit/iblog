package com.alexkbit.iblog.repository.impl;


import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.BookLanguage;
import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.BookRepository;
import com.alexkbit.iblog.repositories.api.ImageRepository;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Repository test for {@link BookRepositoryImpl}
 */
@DatabaseSetup(value = {
        "/datasets/repositories/user/user_three.xml",
        "/datasets/repositories/image/image_four.xml",
        "/datasets/repositories/book/book_some.xml"})
public class BookRepositoryImplTest extends AbstractTestRepository {

    private static final String USER_UUID = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String IMAGE_UUID = "1ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String SINGLE_BOOK_UUID = "Bac8087d-fc14-4e4f-b9d0-5c4b9e05a100";

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSave() {
        Image image = imageRepository.findOne(IMAGE_UUID);
        User user = userRepository.findOne(USER_UUID);
        Book book = new Book();
        book.setImage(image);
        book.setUser(user);
        book.setAuthor("author");
        book.setCurrentPage(0);
        book.setLanguage(BookLanguage.EN);
        book.setPageCount(100);
        book.setPublishYear(2017);
        book.setName("name");
        book.setRate(5.0);
        book.setEndDate(new Date());
        Book newBook = bookRepository.save(book);
        assertNotNull(newBook.getId());
        assertNotNull(newBook.getCreatedAt());
        assertNotNull(newBook.getUpdatedAt());
        assertEquals(book.getName(), newBook.getName());
        assertEquals(book.getAuthor(), newBook.getAuthor());
        assertEquals(book.getCurrentPage(), newBook.getCurrentPage());
        assertEquals(book.getLanguage(), newBook.getLanguage());
        assertEquals(book.getPageCount(), newBook.getPageCount());
        assertEquals(book.getPublishYear(), newBook.getPublishYear());
        assertEquals(book.getEndDate(), newBook.getEndDate());
        assertEquals(book.getRate(), newBook.getRate());
        assertEquals(USER_UUID, newBook.getUser().getId());
        assertEquals(IMAGE_UUID, newBook.getImage().getId());
    }

    @Test
    public void testGetByUuid() {
        Book book = bookRepository.findOne(SINGLE_BOOK_UUID);
        assertNotNull(book);
        assertEquals(book.getId(), SINGLE_BOOK_UUID);
    }
}