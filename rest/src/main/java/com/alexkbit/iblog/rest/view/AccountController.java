package com.alexkbit.iblog.rest.view;


import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.Role;
import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.converters.ImageFileConverter;
import com.alexkbit.iblog.rest.dto.UserDTO;
import com.alexkbit.iblog.servvices.api.ImageService;
import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Login Controller
 */
@Controller
@RequestMapping("account")
public class AccountController extends RESTController<User, UserDTO> {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userId)")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String userId, Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        if (userId.equals(currentUser.getId()) || currentUser.getRole() == Role.ADMIN) {
            User user = userService.get(userId);
            return new ModelAndView("account", "user", mapToDTO(user));
        }
        return new ModelAndView("error");
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userDTO.id)")
    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public ModelAndView uploadingAvatar(@ModelAttribute UserDTO userDTO,
                                      @RequestParam("uploadingFile") MultipartFile uploadingFile) throws IOException {
        Image image = ImageFileConverter.convertTo(uploadingFile);
        image.setUser(userService.get(userDTO.getId()));
        image = imageService.save(image);
        image.getUser().setAvatar(image);
        User user = userService.save(image.getUser());
        return new ModelAndView("account", "user", mapToDTO(user));
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userDTO.id)")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute UserDTO userDTO) {
        User user = userService.get(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user = userService.save(user);
        return new ModelAndView("account", "user", mapToDTO(user));
    }
}
