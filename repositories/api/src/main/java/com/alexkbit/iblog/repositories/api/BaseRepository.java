package com.alexkbit.iblog.repositories.api;

import com.alexkbit.iblog.model.BaseModel;

import java.util.Collection;
import java.util.List;

/**
 * Base interface for repositories with business objects.
 */
public interface BaseRepository<T extends BaseModel> {

    /**
     * Save model.
     * @param model {@link T}
     * @return {@link T}
     */
    T save(T model);

    /**
     * Save collection of models.
     * @param models collections of {@link T}
     * @return collections of {@link T}
     */
    List<T> save(Collection<T> models);

    /**
     * Find model by UUID.
     * @param id UUID
     * @return {@link T}
     */
    T findOne(String id);

    /**
     * Find model by UUID.
     * @param ids UUIDs
     * @return list of{@link T}
     */
    List<T> findByIds(Collection<String> ids);

    /**
     * Remove model.
     * @param model {@link T}
     */
    void delete(T model);

    /**
     * Remove model.
     * @param id UUID
     */
    void delete(String id);

    /**
     * Remove models.
     * @param models collection of {@link T}
     */
    void delete(Collection<T> models);
}
