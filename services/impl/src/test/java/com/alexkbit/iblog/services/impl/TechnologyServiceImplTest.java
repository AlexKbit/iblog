package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.PagingModel;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.repositories.api.TechnologyRepository;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Test for {@link TechnologyServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class TechnologyServiceImplTest extends EasyMockSupport {

    @Mock
    private TechnologyRepository technologyRepository;

    @TestSubject
    private TechnologyServiceImpl technologyService = new TechnologyServiceImpl();

    @Test
    public void testSave() {
        String id = UUID.randomUUID().toString();
        Technology technology = new Technology();
        technology.setId(id);
        expect(technologyRepository.save(anyObject(Technology.class))).andReturn(technology);
        replayAll();
        assertEquals(id, technologyService.save(new Technology()).getId());
        verifyAll();
    }

    @Test
    public void testSaveNull() {
        replayAll();
        assertNull(technologyService.save(null));
        verifyAll();
    }

    @Test
    public void testGetByUuid() {
        String id = UUID.randomUUID().toString();
        Technology technology = new Technology();
        technology.setId(id);
        expect(technologyRepository.findOne(id)).andReturn(technology);
        replayAll();
        assertEquals(id, technologyService.get(id).getId());
        verifyAll();
    }

    @Test
    public void testGetByUuidNotFound() {
        expect(technologyRepository.findOne(anyObject())).andReturn(null);
        replayAll();
        assertNull(technologyService.get(UUID.randomUUID().toString()));
        verifyAll();
    }

    @Test
    public void testGetByUuidIsNull() {
        replayAll();
        assertNull(technologyService.get(null));
        verifyAll();
    }

    @Test
    public void testDeleteByUuid() {
        String id = UUID.randomUUID().toString();
        technologyRepository.delete(eq(id));
        expectLastCall();
        replayAll();
        technologyService.delete(id);
        verifyAll();
    }

    @Test
    public void testDeleteWhenIdIsNull() {
        replayAll();
        technologyService.delete(null);
        verifyAll();
    }

    @Test
    public void testSearch() {
        String id = UUID.randomUUID().toString();
        Technology technology = new Technology();
        technology.setName(id);
        technology.setId(id);
        PagingModel pm = new PagingModel(0,2);
        expect(technologyRepository.searchByName(id, pm)).andReturn(new PageModel<>());
        replayAll();
        assertNotNull(id, technologyService.searchByName(id, pm));
        verifyAll();
    }
}