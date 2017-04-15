package com.alexkbit.iblog.services.impl;

import com.alexkbit.iblog.model.CurrentUser;
import com.alexkbit.iblog.model.Role;
import com.alexkbit.iblog.servvices.api.CurrentUserService;
import org.springframework.stereotype.Service;

/**
 * Implementation for {@link CurrentUserService}
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, String userId) {
        return currentUser != null && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }
}
