package com.alexkbit.iblog.repository.impl.entities;

import java.util.UUID;

/**
 * Base object for all entities
 */
public class BaseEntity {

    /**
     * Unique id of entity
     */
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
