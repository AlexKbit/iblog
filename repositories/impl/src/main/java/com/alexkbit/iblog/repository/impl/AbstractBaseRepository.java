package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.BaseModel;
import com.alexkbit.iblog.repositories.api.BaseRepository;
import com.alexkbit.iblog.repository.impl.entities.BaseEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
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
     * Gets inner jpa repository for this
     * @return {@link JpaRepository}
     */
    protected abstract JpaRepository<E, String> getRepository();

    /**
     * {@inheritDoc}
     */
    @Override
    public M save(M model) {
        E entity = mapToEntity(model);
        getRepository().save(entity);
        return mapToModel(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<M> save(Collection<M> models) {
        List<E> entities = mapToEntity(models);
        getRepository().save(entities);
        return mapToModel(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M findOne(String id) {
        return findOne(() -> this.getRepository().findOne(id));
    }

    protected M findOne(Supplier<E> supplier) {
        E entity = supplier.get();
        if (entity == null) {
            return null;
        }
        return mapToModel(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<M> findByIds(Collection<String> ids) {
        List<E> entities = getRepository().findAll(ids);
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        return mapToModel(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(M model) {
        if (model == null) {
            return;
        }
        getRepository().delete(model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Collection<M> models) {
        if (models == null || models.isEmpty()) {
            return;
        }
        models.stream().map(M::getId).forEach(id -> getRepository().delete(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        getRepository().delete(id);
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
}
