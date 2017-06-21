package com.alexkbit.iblog.rest.common;

import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.rest.converters.ImageFileConverter;
import com.alexkbit.iblog.servvices.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Controller for ajax upload files.
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity uploadingImage(@RequestParam("uploadingFile") MultipartFile uploadingFile,
                                         Authentication authentication) throws IOException {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Image image = ImageFileConverter.convertTo(uploadingFile);
        image.setUser(currentUser.getUser());
        image = imageService.save(image);
        return new ResponseEntity(image.getId(), HttpStatus.OK);
    }
}
