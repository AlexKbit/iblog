package com.alexkbit.iblog.repository.impl;


import com.alexkbit.iblog.model.*;
import com.alexkbit.iblog.repositories.api.*;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import javafx.geometry.Pos;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Repository test for {@link BookRepositoryImpl}
 */
@DatabaseSetup(value = {
        "/datasets/repositories/user/user_three.xml",
        "/datasets/repositories/image/image_four.xml",
        "/datasets/repositories/technology/technology_two.xml",
        "/datasets/repositories/post/post_one.xml"})
public class PostRepositoryImplTest extends AbstractTestRepository {

    private static final String USER_UUID = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String IMAGE_UUID = "1ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String TAG_UUID = "4ac8087d-fc14-4e4f-b9d0-5tttte05a001";

    private static final String POST_UUID = "4ac8087d-fc14-4e4f-b9d0-post0005a001";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testSave() {
        Image image = imageRepository.findOne(IMAGE_UUID);
        User user = userRepository.findOne(USER_UUID);
        Technology technology = technologyRepository.findOne(TAG_UUID);
        Post post = new Post();
        post.setUser(user);
        post.setCover(image);
        post.setTags(Arrays.asList(technology));
        post.setTheme("Theme");
        post.setVisible(true);
        PostElement pe1 = new PostElement();
        pe1.setOrder(0);
        pe1.setContent("Content1");
        pe1.setType(PostElementType.TEXT_BLOCK);
        post.getElementList().add(pe1);
        Post result = postRepository.save(post);
        assertNotNull(result.getId());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());
        assertEquals(result.getUser().getId(), post.getUser().getId());
        assertEquals(result.isVisible(), post.isVisible());
        assertEquals(result.getTheme(), post.getTheme());
        assertEquals(result.getTags().size(), post.getTags().size());
        assertEquals(result.getElementList().size(), post.getElementList().size());
    }

    @Test
    public void testGetByUuid() {
        Post findPost = postRepository.findOne(POST_UUID);
        assertNotNull(findPost);
        assertEquals(findPost.getId(), POST_UUID);
    }

    @Test
    public void testGetPage() {
        PageModel<Post> books = postRepository.findAll(0, 10);
        assertEquals(0, books.getNumber());
        assertEquals(1, books.getNumberOfElements());
        assertEquals(1, books.getTotalElements());
        List<String> ids = books.getContent().stream().map(Post::getId).collect(Collectors.toList());
        assertTrue(ids.contains(POST_UUID));
    }
}