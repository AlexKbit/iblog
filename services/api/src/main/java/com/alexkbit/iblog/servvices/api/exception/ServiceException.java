package com.alexkbit.iblog.servvices.api.exception;

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
