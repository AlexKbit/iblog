package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.repositories.api.TechnologyRepository;
import com.alexkbit.iblog.repository.impl.entities.TechnologyEntity;
import com.alexkbit.iblog.repository.impl.jpa.TechnologyRepositoryJpa;
import com.alexkbit.iblog.repository.impl.utils.SearchSpecificationsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Implementation of {@link TechnologyRepository}.
 */
@Repository
public class TechnologyRepositoryImpl extends AbstractBaseRepository<Technology, TechnologyEntity> implements TechnologyRepository {

    @Autowired
    private TechnologyRepositoryJpa technologyRepositoryJpa;

    @Override
    protected JpaRepository<TechnologyEntity, String> getRepository() {
        return technologyRepositoryJpa;
    }

    @Override
    public PageModel<Technology> searchByName(String query, PagingModel paging) {
        Pageable pageable = new PageRequest(paging.getPage(), paging.getSize());
        Specification<TechnologyEntity> spec = SearchSpecificationsUtils.searchSpecification(query, "name");
        PageModel page = mapToModel(technologyRepositoryJpa.findAll(spec, pageable));
        page.setSearch(query);
        return page;
    }
}
