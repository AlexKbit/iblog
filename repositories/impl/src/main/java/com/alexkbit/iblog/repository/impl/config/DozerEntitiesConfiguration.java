package com.alexkbit.iblog.repository.impl.config;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Dozer configuration for entities from View Service.
 */
@Configuration
public class DozerEntitiesConfiguration {

    /**
     * Location of mapping file for entities.
     */
    private static final String DOZER_FOR_REPOSITORY_CONFIG_LOCATION = "dozer-mappings/dozer-entity-mapping.xml";

    /**
     * Initialize dozer mapper for entities
     *
     * @return dozer mapper
     */
    @Bean
    @Qualifier(value = "entitiesDozerMapper")
    public DozerBeanMapper viewServiceDozerMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Arrays.asList(DOZER_FOR_REPOSITORY_CONFIG_LOCATION));
        return dozerBeanMapper;
    }
}
