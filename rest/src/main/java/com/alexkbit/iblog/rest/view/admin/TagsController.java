package com.alexkbit.iblog.rest.view.admin;

import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.rest.RESTController;
import com.alexkbit.iblog.rest.dto.TechnologyDTO;
import com.alexkbit.iblog.servvices.api.ImageService;
import com.alexkbit.iblog.servvices.api.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private ImageService imageService;

    @RequestMapping("/tags")
    public ModelAndView getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "count", defaultValue = "25") Integer count,
                            @RequestParam(value = "query", defaultValue = "") String query) {
        return new ModelAndView("admin/tags", "page", mapToDTO(technologyService.searchByName(query, new PagingModel(page, count))));
    }

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("admin/tag", "tag", new TechnologyDTO());
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String tagId) {
        Technology tech = technologyService.get(tagId);
        return new ModelAndView("admin/tag", "tag", mapToDTO(tech));
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public String post(@ModelAttribute("form") TechnologyDTO dto,
                       Authentication authentication) {
        Technology tech = mapToModel(dto);
        tech.setImage(imageService.get(dto.getImageId()));
        technologyService.save(tech);
        return "redirect:/admin/tags";
    }

    @RequestMapping(value = "/tag/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") String tagId) {
        technologyService.delete(tagId);
        return "redirect:/admin/tags";
    }
}
