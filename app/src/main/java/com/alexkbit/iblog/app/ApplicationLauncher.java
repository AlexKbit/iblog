package com.alexkbit.iblog.app;

import com.alexkbit.iblog.app.config.ProjectProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Launcher for spring boot application.
 */
@SpringBootApplication
@ComponentScan(ProjectProperties.BASE_PACKAGE)
@EnableAutoConfiguration
public class ApplicationLauncher {

    /**
     * Start application.
     *
     * @param args arguments
     */
    public static void main(String... args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
