package com.alexkbit.iblog.repository.impl.entities;

import com.alexkbit.iblog.model.PostElement;

/**
 * Type of {@link PostElement}.
 */
public enum PostElementType {
    /**
     * Block of free text.
     */
    TEXT_BLOCK,
    /**
     * Image.
     */
    IMAGE,
    /**
     * Text block with code format.
     */
    CODE
}
