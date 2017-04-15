package com.alexkbit.iblog.rest.view.exception;

import com.alexkbit.iblog.servvices.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static Logger log = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(ServiceException.class)
    public ModelAndView handlServiceException(Exception e) {
        log.error("Error: ", e);
        return new ModelAndView("error","msg", e.getMessage());
    }

}
