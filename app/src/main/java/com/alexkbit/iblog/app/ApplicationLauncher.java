package com.alexkbit.iblog.app;

import com.alexkbit.iblog.app.config.ProjectProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Launcher for spring boot application.
 */
@SpringBootApplication
@ComponentScan(ProjectProperties.BASE_PACKAGE)
public class ApplicationLauncher extends SpringBootServletInitializer {

    /**
     * Start application.
     *
     * @param args arguments
     */
    public static void main(String... args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationLauncher.class);
    }
}
