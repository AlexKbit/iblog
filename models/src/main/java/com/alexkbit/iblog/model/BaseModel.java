package com.alexkbit.iblog.model;

import java.util.UUID;

/**
 * Base object for models
 */
public class BaseModel {

    /**
     * Unique id of model
     */
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
