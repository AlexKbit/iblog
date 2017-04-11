package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Role;
import com.alexkbit.iblog.model.User;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link CurrentUserServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class CurrentUserServiceImplTest extends EasyMockSupport {

    @TestSubject
    private CurrentUserServiceImpl currentUserService = new CurrentUserServiceImpl();

    @Test
    public void testAccessToAnyUserForAdmin() {
        CurrentUser currentUser = createUser(Role.ADMIN);
        replayAll();
        assertTrue(currentUserService.canAccessUser(currentUser, UUID.randomUUID().toString()));
        verifyAll();
    }

    @Test
    public void testAccessToAnyUserForUser() {
        CurrentUser currentUser = createUser(Role.USER);
        replayAll();
        assertFalse(currentUserService.canAccessUser(currentUser, UUID.randomUUID().toString()));
        verifyAll();
    }

    @Test
    public void testAccessForUser() {
        CurrentUser currentUser = createUser(Role.USER);
        replayAll();
        assertTrue(currentUserService.canAccessUser(currentUser, currentUser.getId()));
        verifyAll();
    }

    private CurrentUser createUser(Role role) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(user.getId());
        user.setPassword(user.getId());
        user.setRole(role);
        return new CurrentUser(user);
    }
}