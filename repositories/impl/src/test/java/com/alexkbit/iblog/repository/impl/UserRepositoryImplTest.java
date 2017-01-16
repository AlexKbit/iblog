package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Repository test for {@link UserRepositoryImpl}
 */
public class UserRepositoryImplTest extends AbstractRepositoryTest {

    private String USER_ONE_UUID = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a539";

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setLogin("user");
        user.setEmail("user@mail.com");
        User newUser = userRepository.save(user);
        assertNotNull(newUser.getId());
        //assertNotNull(newUser.getCreatedAt()); // TODO FIX
        //assertNotNull(newUser.getUpdatedAt());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertEquals(user.getLogin(), newUser.getLogin());
    }

    @Test
    @Ignore
    @DatabaseSetup(value = "/datasets/repositories/user/user_one.xml")
    public void testGetByUuid() {
        User user = userRepository.findOne(USER_ONE_UUID);
        assertNotNull(user);
        assertEquals(user.getId(), USER_ONE_UUID);
    }

}