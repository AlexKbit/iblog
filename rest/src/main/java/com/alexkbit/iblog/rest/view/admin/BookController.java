package com.alexkbit.iblog.rest.view.admin;


import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ImageType;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.BookDTO;
import com.alexkbit.iblog.servvices.api.BookService;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Book Controller
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

    @RequestMapping(value = "/book/image", method = RequestMethod.POST)
    public ModelAndView uploadingPost(@ModelAttribute BookDTO bookDTO,
                                      @RequestParam("uploadingFile") MultipartFile uploadingFile,
                                      Authentication authentication) throws IOException {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Image image = new Image();
        image.setData(uploadingFile.getBytes());
        image.setName(uploadingFile.getOriginalFilename());
        image.setType(ImageType.valueOf(uploadingFile.getContentType().split("/")[1].toUpperCase()));
        image.setUser(currentUser.getUser());
        image = imageService.save(image);
        bookDTO.setImageId(image.getId());
        return new ModelAndView("admin/book", "book", bookDTO);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView bookPost(@ModelAttribute("form") BookDTO dto,
                                 Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Book book = mapToModel(dto);
        book.setUser(currentUser.getUser());
        book.setImage(imageService.get(dto.getImageId()));
        bookService.save(book);
        return new ModelAndView("library");
    }
}
