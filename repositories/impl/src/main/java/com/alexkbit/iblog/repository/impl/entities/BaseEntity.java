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
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @PrePersist
    public void init() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
