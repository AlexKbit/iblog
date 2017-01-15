package com.alexkbit.iblog.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.dataset.FlatXmlDataSetLoader;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Profile for test of repositories
 */
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("repository-tests")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class, databaseConnection = "dataSource")
@SpringApplicationConfiguration(RepositoryTestApplication.class)
public @interface RepositoryTestProfile {

}
