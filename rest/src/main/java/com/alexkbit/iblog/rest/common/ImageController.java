package com.alexkbit.iblog.rest.common;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * REST controller for images
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    private static final String CONTENT_TYPES = "image/jpeg, image/jpg, image/png, image/gif";

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void get(@PathVariable String id, HttpServletResponse response) throws IOException {
        Image image = imageService.get(id);
        if (image == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.setContentType(CONTENT_TYPES);
        response.getOutputStream().write(image.getData());
        response.getOutputStream().close();
    }
}
