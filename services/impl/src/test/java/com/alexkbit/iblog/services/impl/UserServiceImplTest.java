package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.alexkbit.iblog.services.impl.exception.ServiceException;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Test for {@link UserServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class UserServiceImplTest extends EasyMockSupport {

    @Mock
    private UserRepository userRepository;

    @TestSubject
    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void testGetByUuid() {
        UUID id = UUID.randomUUID();
        User user = new User();
        user.setId(id);
        expect(userRepository.findOne(id)).andReturn(user);
        replayAll();
        assertEquals(id, userService.get(id).getId());
        verifyAll();
    }

    @Test
    public void testGetByUuidNotFound() {
        expect(userRepository.findOne(anyObject())).andReturn(null);
        replayAll();
        assertNull(userService.get(UUID.randomUUID()));
        verifyAll();
    }

    @Test
    public void testRegister() {
        String login = "user";
        User user = new User();
        user.setLogin(login);
        expect(userRepository.findByLogin(eq(login))).andReturn(null);
        expect(userRepository.save(eq(user))).andReturn(user);
        replayAll();
        userService.register(user);
        verifyAll();
    }

    @Test
    public void testRegisterException() {
        String login = "user";
        User user = new User();
        user.setLogin(login);
        expect(userRepository.findByLogin(eq(login))).andReturn(new User());
        replayAll();
        try {
            userService.register(user);
            fail("Should throw exception.");
        } catch (ServiceException se) {
            verifyAll();
        }
    }

}