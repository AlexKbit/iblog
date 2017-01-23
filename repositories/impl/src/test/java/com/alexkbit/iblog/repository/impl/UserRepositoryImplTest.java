package com.alexkbit.iblog.repository.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Repository test for {@link UserRepositoryImpl}
 */
public class UserRepositoryImplTest extends AbstractRepositoryTest {

    private String USER_UUID_1 = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private String USER_UUID_2 = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a502";

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
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testGetByUuid() {
        User user = userRepository.findOne(USER_UUID_1);
        assertNotNull(user);
        assertEquals(user.getId(), USER_UUID_1);
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testGetByUuidNotFound() {
        User user = userRepository.findOne(UUID.randomUUID().toString());
        assertNull(user);
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testGetByUuids() {
        List<String> expectedIds = Arrays.asList(USER_UUID_1, USER_UUID_2);
        List<User> users = userRepository.findByIds(expectedIds);
        assertNotNull(users);
        assertEquals(2, users.size());
        assertTrue(expectedIds.contains(users.get(0).getId()));
        assertTrue(expectedIds.contains(users.get(1).getId()));
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testGetByUuidsNotFound() {
        List<String> ids = Arrays.asList("ids");
        List<User> users = userRepository.findByIds(ids);
        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testDelete() {
        assertNotNull(userRepository.findOne(USER_UUID_1));
        userRepository.delete(USER_UUID_1);
        assertNull(userRepository.findOne(USER_UUID_1));
    }

    @Test
    public void testDeleteModelIsNull() {
        User user = null;
        userRepository.delete(user);
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testDeleteModel() {
        User user = userRepository.findOne(USER_UUID_1);
        assertNotNull(user);
        assertEquals(user.getId(), USER_UUID_1);
        userRepository.delete(user);
        user = userRepository.findOne(USER_UUID_1);
        assertNull(user);
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testDeleteByModels() {
        List<User> users = userRepository.findByIds(Arrays.asList(USER_UUID_1, USER_UUID_2));
        assertFalse(users.isEmpty());
        userRepository.delete(users);
        users = userRepository.findByIds(Arrays.asList(USER_UUID_1, USER_UUID_2));
        assertTrue(users.isEmpty());
    }

    @Test
    public void testDeleteModelsIsNull() {
        List<User> users = Collections.emptyList();
        userRepository.delete(users);
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testFindByLogin() {
        String login = "user1001";
        assertNotNull(userRepository.findByLogin(login));
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testFindByLoginNotExist() {
        String login = "user";
        assertNull(userRepository.findByLogin(login));
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testFindByEmail() {
        String login = "user1001@mail.com";
        assertNotNull(userRepository.findByEmail(login));
    }

    @Test
    @DatabaseSetup(value = "/datasets/repositories/user/user_three.xml")
    public void testFindByEmailNotExist() {
        String login = "user@mail.com";
        assertNull(userRepository.findByEmail(login));
    }

    private void assertUser(User old, User newUser) {
        assertNotNull(newUser.getId());
        assertNotNull(newUser.getCreatedAt());
        assertNotNull(newUser.getUpdatedAt());
        assertEquals(old.getEmail(), newUser.getEmail());
        assertEquals(old.getLogin(), newUser.getLogin());
    }

}