package com.alexkbit.iblog.rest.view;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.BookDTO;
import com.alexkbit.iblog.servvices.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller of library page
 */
@Controller
public class LibraryController extends RESTController<Book, BookDTO> {

    @Autowired
    private BookService bookService;

    @RequestMapping("/library")
    public ModelAndView get(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "count", defaultValue = "5") Integer count) {
        return new ModelAndView("library", "page", mapToDTO(bookService.get(page, count)));
    }
}
