package com.alexkbit.iblog.app.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration for JPA
 */
@Configuration
@EntityScan(ProjectProperties.ENTITIES_PACKAGE)
@EnableJpaRepositories(basePackages = ProjectProperties.REPOSITORIES_PACKAGE)
public class JpaConfiguration {

}
