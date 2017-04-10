/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.exceptions;

import java.sql.SQLException;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author mridwan
 */
@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

    protected Logger logger;

    public GlobalExceptionHandlingControllerAdvice() {
        logger = LoggerFactory.getLogger(getClass());
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
 /* . . . . . . . . . . . . . EXCEPTION HANDLERS . . . . . . . . . . . . . . */
 /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /**
     * Convert a predefined exception to an HTTP Status code
     *
     * @param exception
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Illegal Input")
    @ExceptionHandler({IllegalInputException.class})
    public void illegalInput(Exception exception) {
        logger.error("Request raised " + exception.getClass().getSimpleName());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity Not Found")
    @ExceptionHandler({EntityNotFoundException.class})
    public void entityNotFound(Exception exception) {
        logger.error("Request raised " + exception.getClass().getSimpleName());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page Not Found")
    @ExceptionHandler({PageNotFoundException.class})
    public void pageNotFound(Exception exception) {
        logger.error("Request raised " + exception.getClass().getSimpleName());
    }

}
