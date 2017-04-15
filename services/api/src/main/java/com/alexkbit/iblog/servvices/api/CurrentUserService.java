package com.alexkbit.iblog.servvices.api;

import com.alexkbit.iblog.model.CurrentUser;

/**
 * Service for current user
 */
public interface CurrentUserService {

    /**
     * Check access for current user
     * @param currentUser current user
     * @param userId possible id for access
     * @return true or false
     */
    boolean canAccessUser(CurrentUser currentUser, String userId);
}
