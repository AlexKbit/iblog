package com.alexkbit.iblog.rest.api;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.UserDTO;
import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for users
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends RESTController<User, UserDTO> {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    ResponseEntity<?> get(@PathVariable String id) {
        User user = userService.get(id);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapToDTO(user));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        User user = mapToModel(userDTO);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        user = userService.register(user);
        return ResponseEntity.ok(mapToDTO(user));
    }
}
