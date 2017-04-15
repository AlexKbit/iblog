package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ModelPage;
import com.alexkbit.iblog.repositories.api.ImageRepository;
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
 * Test for {@link ImageServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class ImageServiceImplTest extends EasyMockSupport {

    @Mock
    private ImageRepository imageRepository;

    @TestSubject
    private ImageServiceImpl imageService = new ImageServiceImpl();

    @Test
    public void testSave() {
        String id = UUID.randomUUID().toString();
        Image image = new Image();
        image.setId(id);
        expect(imageRepository.save(anyObject(Image.class))).andReturn(image);
        replayAll();
        assertEquals(id, imageService.save(new Image()).getId());
        verifyAll();
    }

    @Test
    public void testSaveNull() {
        replayAll();
        assertNull(imageService.save(null));
        verifyAll();
    }

    @Test
    public void testGetByUuid() {
        String id = UUID.randomUUID().toString();
        Image image = new Image();
        image.setId(id);
        expect(imageRepository.findOne(id)).andReturn(image);
        replayAll();
        assertEquals(id, imageService.get(id).getId());
        verifyAll();
    }

    @Test
    public void testGetByUser() {
        String id = UUID.randomUUID().toString();
        expect(imageRepository.findByUserId(eq(id), eq(0), eq(10))).andReturn(new ModelPage<>());
        replayAll();
        assertNotNull(id, imageService.getByUser(id, 0, 10));
        verifyAll();
    }

    @Test
    public void testGetByUuidNotFound() {
        expect(imageRepository.findOne(anyObject())).andReturn(null);
        replayAll();
        assertNull(imageService.get(UUID.randomUUID().toString()));
        verifyAll();
    }

    @Test
    public void testGetByUuidIsNull() {
        replayAll();
        assertNull(imageService.get(null));
        verifyAll();
    }
}