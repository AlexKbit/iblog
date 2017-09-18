package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.PageModel;
import com.alexkbit.iblog.model.Post;
import com.alexkbit.iblog.model.PostElement;
import com.alexkbit.iblog.model.PostElementType;
import com.alexkbit.iblog.repositories.api.PostRepository;
import com.alexkbit.iblog.servvices.api.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Implementation of {@link PostService}
 */
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        if (post == null) {
            return null;
        }
        Post newPost = postRepository.save(post);
        log.debug("Save new post with id = {}", newPost.getId());
        return newPost;
    }

    @Override
    public Post get(String uuid) {
        log.debug("Gets post with id = {}", uuid);
        return postRepository.findOne(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (uuid == null) {
            return;
        }
        log.debug("Delete post with id = {}", uuid);
        postRepository.delete(uuid);
    }

    @Override
    public PageModel<Post> get(int page, int count) {
        log.debug("Load page = {} with count = {} of posts", page, count);
        return postRepository.findAll(page, count);
    }

    @Override
    public Post createNewElement(String uuid, PostElementType type) {
        Post post = postRepository.findOne(uuid);
        PostElement pe = new PostElement();
        pe.setType(type);
        pe.setOrder(post.nextOrder());
        post.getElementList().add(pe);
        log.debug("Create new element with order = {} for post = {}", pe.getOrder(), uuid);
        return postRepository.save(post);
    }

    @Override
    public Post moveElementUp(String uuid, int currentOrder) {
        log.debug("Move post element up for uuid = {} currentOrder = {}", uuid, currentOrder);
        Post post = postRepository.findOne(uuid);
        if (currentOrder <= 0) {
            return post;
        }
        Optional<PostElement> current = post.findElement(currentOrder);
        Optional<PostElement> upper = post.findElement(currentOrder - 1);
        if (upper.isPresent() && current.isPresent()) {
            current.get().setOrder(currentOrder - 1);
            upper.get().setOrder(currentOrder);
        }
        return postRepository.save(post);
    }

    @Override
    public Post moveElementDown(String uuid, int currentOrder) {
        log.debug("Move post element down for uuid = {} currentOrder = {}", uuid, currentOrder);
        Post post = postRepository.findOne(uuid);
        if (post.maxOrder() == 0) {
            return post;
        }
        Optional<PostElement> current = post.findElement(currentOrder);
        Optional<PostElement> down = post.findElement(currentOrder - 1);
        if (down.isPresent() && current.isPresent()) {
            current.get().setOrder(currentOrder + 1);
            down.get().setOrder(currentOrder);
        }
        return postRepository.save(post);
    }
}
