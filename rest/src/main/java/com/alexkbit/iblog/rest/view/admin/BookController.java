package com.alexkbit.iblog.rest.view.admin;


import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.BookDTO;
import com.alexkbit.iblog.servvices.api.BookService;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for book page
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("admin")
public class BookController extends RESTController<Book, BookDTO> {

    @Autowired
    private BookService bookService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("admin/book", "book", new BookDTO());
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String bookId) {
        Book book = bookService.get(bookId);
        return new ModelAndView("admin/book", "book", mapToDTO(book));
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String post(@ModelAttribute("form") BookDTO dto,
                                 Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Book book = mapToModel(dto);
        book.setUser(currentUser.getUser());
        book.setImage(imageService.get(dto.getImageId()));
        bookService.save(book);
        return "redirect:/library";
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") String bookId) {
        bookService.delete(bookId);
        return "redirect:/library";
    }
}
