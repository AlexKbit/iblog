package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

/**
 * Base object for all entities
 */
@MappedSuperclass
public class BaseEntity {

    /**
     * Unique id of entity
     */
    @Id
    @Column(name = "uuid", length = 36)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PrePersist
    protected void init() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
