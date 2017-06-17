package com.alexkbit.iblog.repository.impl;


import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ImageType;
import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.repositories.api.ImageRepository;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Repository test for {@link ImageRepositoryImpl}
 */
@DatabaseSetup(value = {
        "/datasets/repositories/user/user_three.xml",
        "/datasets/repositories/image/image_four.xml"})
public class ImageRepositoryImplTest extends AbstractTestRepository {

    private static final String USER_UUID_1 = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String USER_UUID_2 = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a502";

    private static final String USER_UUID_3 = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a503";

    private static final String SINGLE_IMAGE_UUID = "1ac8087d-fc14-4e4f-b9d0-5c4b9e05a504";

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        Image image = new Image();
        image.setData(new byte[10]);
        image.setName("img");
        image.setType(ImageType.JPG);
        image.setUser(userRepository.findOne(USER_UUID_3));
        Image newImage = imageRepository.save(image);
        assertNotNull(newImage.getId());
        assertNotNull(newImage.getCreatedAt());
        assertNotNull(newImage.getUpdatedAt());
        assertEquals(image.getData().length, newImage.getData().length);
        assertEquals(image.getName(), newImage.getName());
        assertEquals(image.getType(), newImage.getType());
    }

    @Test
    public void testGetByUuid() {
        Image image = imageRepository.findOne(SINGLE_IMAGE_UUID);
        assertNotNull(image);
        assertEquals(image.getId(), SINGLE_IMAGE_UUID);
        assertEquals(image.getUser().getId(), USER_UUID_2);
    }

    @Test
    public void testFindByUserId() {
        PageModel<Image> images = imageRepository.findByUserId(USER_UUID_1, 0, 10);
        assertEquals(0, images.getNumber());
        assertEquals(3, images.getNumberOfElements());
        assertEquals(3, images.getTotalElements());
        List<String> ids = images.getContent().stream().map(Image::getId).collect(Collectors.toList());
        assertTrue(ids.contains("1ac8087d-fc14-4e4f-b9d0-5c4b9e05a501"));
        assertTrue(ids.contains("1ac8087d-fc14-4e4f-b9d0-5c4b9e05a502"));
        assertTrue(ids.contains("1ac8087d-fc14-4e4f-b9d0-5c4b9e05a503"));
    }

    @Test
    public void testFindByUserIdNotFound() {
        PageModel<Image> images = imageRepository.findByUserId(UUID.randomUUID().toString(), 0, 10);
        assertEquals(0, images.getNumber());
        assertEquals(0, images.getNumberOfElements());
        assertEquals(0, images.getTotalElements());
        assertTrue(images.getContent().isEmpty());
    }
}