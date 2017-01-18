package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.repository.RepositoryTestApplication;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.dataset.FlatXmlDataSetLoader;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

/**
 * Abstract configuration class for test repositories
 */
@ActiveProfiles("repository-tests")
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class, databaseConnection = "dataSource")
@TestExecutionListeners({
        DbUnitTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class
})
@SpringApplicationConfiguration(RepositoryTestApplication.class)
public class AbstractRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
}
