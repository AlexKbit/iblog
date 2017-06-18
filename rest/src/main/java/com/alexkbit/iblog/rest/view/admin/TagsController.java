package com.alexkbit.iblog.rest.view.admin;

import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.TechnologyDTO;
import com.alexkbit.iblog.servvices.api.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for page with list of tags/technologies
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("admin")
public class TagsController extends RESTController<Technology, TechnologyDTO> {

    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/tags")
    public ModelAndView get(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "count", defaultValue = "25") Integer count,
                            @RequestParam(value = "query", defaultValue = "") String query) {
        return new ModelAndView("admin/tags", "page", mapToDTO(technologyService.searchByName(query, new PagingModel(page, count))));
    }
}
