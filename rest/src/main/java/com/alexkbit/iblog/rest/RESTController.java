package com.alexkbit.iblog.rest;

import com.alexkbit.iblog.model.BaseModel;
import com.alexkbit.iblog.rest.dto.BaseDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Base REST controller
 */
public abstract class RESTController<M extends BaseModel, D extends BaseDTO> {

    /**
     * Dozer mapper
     */
    @Autowired
    @Qualifier(value = "dtoDozerMapper")
    private DozerBeanMapper mapper;


    /**
     * Type of model.
     */
    private Class<M> modelClass;

    /**
     * Type of entity.
     */
    private Class<D> dtoClass;

    /**
     * Determine types.
     */
    @PostConstruct
    public void init() {
        modelClass = (Class<M>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        dtoClass = (Class<D>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[1];
    }

    /**
     * Map model to entity
     * @param model {@link M}
     * @return {@link D}
     */
    protected D mapToDTO(M model) {
        return mapper.map(model, dtoClass);
    }

    /**
     * Map entity to model
     * @param dto {@link D}
     * @return {@link M}
     */
    protected M mapToModel(D dto) {
        return mapper.map(dto, modelClass);
    }

    /**
     * Map models to entities
     * @param models collection of {@link M}
     * @return list of {@link D}
     */
    protected List<D> mapToDTO(Collection<M> models) {
        return models.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    /**
     * Map entities to models
     * @param entities collection of {@link D}
     * @return list of {@link M}
     */
    protected List<M> mapToModel(Collection<D> entities) {
        return entities.stream().map(this::mapToModel).collect(Collectors.toList());
    }
}
