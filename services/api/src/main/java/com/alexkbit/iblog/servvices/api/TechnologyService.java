package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;

/**
 * Service for {@link Technology}.
 */
public interface TechnologyService {

    /**
     * Save {@link Technology}.
     * @param technology {@link Technology}
     * @return new {@link Technology}
     */
    Technology save(Technology technology);

    /**
     * Get {@link Technology} by id.
     * @param id id of {@link Technology}
     * @return {@link Technology}
     */
    Technology get(String id);

    /**
     * Delete {@link Technology} by id.
     * @param uuid UUID
     */
    void delete(String uuid);

    /**
     * Search {@link Technology} by name.
     * @param query full name or part of name
     * @param paging {@link PagingModel}
     * @return page
     */
    PageModel<Technology> searchByName(String query, PagingModel paging);
}
