package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.BaseModel;
import com.alexkbit.iblog.repositories.api.BaseRepository;
import com.alexkbit.iblog.repository.impl.entities.BaseEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract implementation of {@link BaseRepository}
 */
public abstract class AbstractBaseRepository<M extends BaseModel, E extends BaseEntity> implements BaseRepository<M> {

    /**
     * Dozer mapper
     */
    @Autowired
    @Qualifier(value = "entitiesDozerMapper")
    private DozerBeanMapper dozerBeanMapper;

    /**
     * Type of model.
     */
    private Class<M> modelClass;

    /**
     * Type of entity.
     */
    private Class<E> entityClass;

    /**
     * Determine types.
     */
    @PostConstruct
    public void init() {
        modelClass = (Class<M>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        entityClass = (Class<E>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[1];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M save(M model) {
        E entity = mapToEntity(model);
        saveEntity(entity);
        model.setId(entity.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<M> save(Collection<M> models) {
        List<E> entities = mapToEntity(models);
        saveEntities(entities);
        return mapToModel(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M findOne(String id) {
        E entity = findById(id);
        if (entity != null) {
            return mapToModel(entity);
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(M model) {
        if (model == null) {
            return;
        }
        deleteById(model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Collection<M> models) {
        if (models == null || models.isEmpty()) {
            return;
        }
        models.stream().map(M::getId).forEach(id -> deleteById(id));
    }

    /**
     * Map model to entity
     * @param model {@link M}
     * @return {@link E}
     */
    protected E mapToEntity(M model) {
        return dozerBeanMapper.map(model, entityClass);
    }

    /**
     * Map entity to model
     * @param entity {@link E}
     * @return {@link M}
     */
    protected M mapToModel(E entity) {
        return dozerBeanMapper.map(entity, modelClass);
    }

    /**
     * Map models to entities
     * @param models collection of {@link M}
     * @return list of {@link E}
     */
    protected List<E> mapToEntity(Collection<M> models) {
        return models.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    /**
     * Map entities to models
     * @param entities collection of {@link E}
     * @return list of {@link M}
     */
    protected List<M> mapToModel(Collection<E> entities) {
        return entities.stream().map(this::mapToModel).collect(Collectors.toList());
    }

    /**
     * Save entity to DB.
     *
     * @param entity {@link E}
     */
    protected abstract void saveEntity(E entity);

    /**
     * Save entities to DB.
     *
     * @param entities collection of entity
     */
    protected abstract void saveEntities(Collection<E> entities);

    /**
     * Find entity by uuid.
     *
     * @param uuid uuid
     * @return entity
     */
    protected abstract E findById(String uuid);

    /**
     * Delete entity by id from DB.
     *
     * @param id id of entity
     */
    protected abstract void deleteById(String id);
}
