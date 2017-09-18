package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.Post;
import com.alexkbit.iblog.repositories.api.PostRepository;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Test for {@link ImageServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class PostServiceImplTest extends EasyMockSupport {

    @Mock
    private PostRepository postRepository;

    @TestSubject
    private PostServiceImpl postService = new PostServiceImpl();

    @Test
    public void testSave() {
        String id = UUID.randomUUID().toString();
        Post post = new Post();
        post.setId(id);
        expect(postRepository.save(anyObject(Post.class))).andReturn(post);
        replayAll();
        assertEquals(id, postService.save(new Post()).getId());
        verifyAll();
    }

    @Test
    public void testSaveNull() {
        replayAll();
        assertNull(postService.save(null));
        verifyAll();
    }

    @Test
    public void testGetPage() {
        expect(postRepository.findAll(eq(0), eq(10))).andReturn(new PageModel<>());
        replayAll();
        assertNotNull(postService.get(0,10));
        verifyAll();
    }

    @Test
    public void testGetByUuid() {
        String id = UUID.randomUUID().toString();
        Post Post = new Post();
        Post.setId(id);
        expect(postRepository.findOne(id)).andReturn(Post);
        replayAll();
        assertEquals(id, postService.get(id).getId());
        verifyAll();
    }

    @Test
    public void testDeleteByUuid() {
        String id = UUID.randomUUID().toString();
        postRepository.delete(eq(id));
        expectLastCall();
        replayAll();
        postService.delete(id);
        verifyAll();
    }

    @Test
    public void testDeleteWhenIdIsNull() {
        replayAll();
        postService.delete(null);
        verifyAll();
    }

    @Test
    public void testGetByUuidNotFound() {
        expect(postRepository.findOne(anyObject())).andReturn(null);
        replayAll();
        assertNull(postService.get(UUID.randomUUID().toString()));
        verifyAll();
    }

}
