package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;

/**
 * Business repository fo {@link Technology}.
 */
public interface TechnologyRepository extends BaseRepository<Technology> {

    /**
     * Find {@link Technology} by name.
     * @param query some chars from name
     * @param paging paging
     * @return page
     */
    PageModel<Technology> searchByName(String query, PagingModel paging);
}
