package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

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
        assertUser(user, newUser);
    }

    @Test
    public void testSaveList() {
        User user1 = new User();
        user1.setLogin("user1");
        user1.setEmail("user1@mail.com");
        User user2 = new User();
        user2.setLogin("user2");
        user2.setEmail("user2@mail.com");
        List<User> newUsers = userRepository.save(Arrays.asList(user1, user2));
        assertNotNull(newUsers);
        assertEquals(2, newUsers.size());
        assertUser(user1, newUsers.get(0));
        assertUser(user2, newUsers.get(1));
    }

    @Test
    @Ignore
    @DatabaseSetup(value = "/datasets/repositories/user/user_one.xml")
    public void testGetByUuid() {
        User user = userRepository.findOne(USER_ONE_UUID);
        assertNotNull(user);
        assertEquals(user.getId(), USER_ONE_UUID);
    }

    private void assertUser(User old, User newUser) {
        assertNotNull(newUser.getId());
        assertNotNull(newUser.getCreatedAt());
        assertNotNull(newUser.getUpdatedAt());
        assertEquals(old.getEmail(), newUser.getEmail());
        assertEquals(old.getLogin(), newUser.getLogin());
    }

}