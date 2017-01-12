package com.alexkbit.iblog.app.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * Configuration for JPA
 */
@Configuration
@EntityScan(ProjectProperties.ENTITIES_PACKAGE)
@EnableJpaRepositories(basePackages = ProjectProperties.REPOSITORIES_PACKAGE)
public class JpaConfiguration {

    @Bean
    @Profile(value = {"dev", "test", "prod"})
    public DataSource dataSource() {
        String username = System.getenv("DATABASE_USER");
        String password = System.getenv("DATABASE_PASSWORD");
        String dbUrl = System.getenv("DATABASE_JDBC_URL");

        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
