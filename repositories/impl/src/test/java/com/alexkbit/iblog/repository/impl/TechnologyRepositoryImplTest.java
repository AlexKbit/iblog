package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.repositories.api.TechnologyRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Repository test for {@link ResumeRepositoryImpl}
 */
@DatabaseSetup(value = {
        "/datasets/repositories/technology/technology_two.xml"})
public class TechnologyRepositoryImplTest extends AbstractTestRepository {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Test
    public void testSave() {
        Technology technology = new Technology();
        technology.setName("Java");
        technology.setDescription("desc");
        Technology newTechnology = technologyRepository.save(technology);
        assertNotNull(newTechnology.getId());
        assertNotNull(newTechnology.getCreatedAt());
        assertNotNull(newTechnology.getUpdatedAt());
        assertEquals(technology.getName(), newTechnology.getName());
        assertEquals(technology.getDescription(), newTechnology.getDescription());
    }

    @Test
    public void testSearch() {
        String searchName = "Java";
        PageModel<Technology> page = technologyRepository.searchByName(searchName, new PagingModel(0,10));
        assertNotNull(page);
        assertFalse(page.getContent().isEmpty());
        assertEquals(searchName, page.getContent().get(0).getName());
    }

    @Test
    public void testSearchAll() {
        PageModel<Technology> page = technologyRepository.searchByName("", new PagingModel(0,10));
        assertNotNull(page);
        assertFalse(page.getContent().isEmpty());
        assertEquals(2, page.getContent().size());
    }

}