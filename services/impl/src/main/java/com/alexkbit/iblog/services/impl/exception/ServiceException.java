package com.alexkbit.iblog.services.impl.exception;

/**
 * Runtime Exception for service layer
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable th) {
        super(message, th);
    }
}
