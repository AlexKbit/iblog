package com.alexkbit.iblog.model;

import java.util.List;

/**
 * Model of user resume
 */
public class Resume extends BaseModel {

    /**
     * User of resume
     */
    private User user;

    /**
     * List of work positions
     */
    private List<WorkPosition> positions;

    /**
     * List of certificates
     */
    private List<Certificate> certificates;
}

