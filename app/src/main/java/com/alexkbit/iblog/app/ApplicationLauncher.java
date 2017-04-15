package com.alexkbit.iblog.app;

import com.alexkbit.iblog.app.config.ProjectProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Launcher for spring boot application.
 */
@SpringBootApplication
@ComponentScan(ProjectProperties.BASE_PACKAGE)
public class ApplicationLauncher extends WebMvcConfigurerAdapter {

    /**
     * Start application.
     *
     * @param args arguments
     */
    public static void main(String... args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
}
