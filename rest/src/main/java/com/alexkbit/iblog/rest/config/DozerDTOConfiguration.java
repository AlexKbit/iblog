package com.alexkbit.iblog.rest.config;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Dozer configuration for entities from View Service.
 */
@Configuration
public class DozerDTOConfiguration {

    /**
     * Location of mapping file for rest api.
     */
    private static final String DOZER_FOR_REST_API_CONFIG_LOCATION = "dozer-mappings/dozer-dto-mapping.xml";

    /**
     * Initialize dozer mapper for DTOs
     *
     * @return dozer mapper
     */
    @Bean
    @Qualifier(value = "dtoDozerMapper")
    public DozerBeanMapper viewServiceDtoDozerMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Arrays.asList(DOZER_FOR_REST_API_CONFIG_LOCATION));
        return dozerBeanMapper;
    }
}
