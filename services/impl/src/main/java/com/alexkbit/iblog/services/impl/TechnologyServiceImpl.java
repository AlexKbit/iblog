package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.repositories.api.TechnologyRepository;
import com.alexkbit.iblog.servvices.api.TechnologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link TechnologyService}
 */
@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

    private static final Logger log = LoggerFactory.getLogger(TechnologyServiceImpl.class);

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public Technology save(Technology technology) {
        if (technology == null) {
            return null;
        }
        Technology newTechnology = technologyRepository.save(technology);
        log.debug("Save technology with id = {}", newTechnology.getId());
        return newTechnology;
    }

    @Override
    public Technology get(String id) {
        if (id == null) {
            return null;
        }
        log.debug("Get technology by id = {}", id);
        return technologyRepository.findOne(id);
    }

    @Override
    public void delete(String uuid) {
        if (uuid == null) {
            return;
        }
        log.debug("Delete technology with id = {}", uuid);
        technologyRepository.delete(uuid);
    }

    @Override
    public PageModel<Technology> searchByName(String query, PagingModel paging) {
        log.debug("Search technology by name = {} paging = {}", query, paging);
        return technologyRepository.searchByName(query, paging);
    }
}
