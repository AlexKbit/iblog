package com.alexkbit.iblog.rest.view;

import com.alexkbit.iblog.model.Post;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.PostDTO;
import com.alexkbit.iblog.servvices.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for page of posts
 */
@Controller
public class PostsController extends RESTController<Post, PostDTO> {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public ModelAndView get(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "count", defaultValue = "7") Integer count) {
        return new ModelAndView("posts", "page", mapToDTO(postService.get(page, count)));
    }
}
