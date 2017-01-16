package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.repository.RepositoryTestApplication;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.dataset.FlatXmlDataSetLoader;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Abstract configuration class for test repositories
 */
@ActiveProfiles("repository-tests")
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class, databaseConnection = "dataSource")
@SpringApplicationConfiguration(RepositoryTestApplication.class)
public class AbstractRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
}
