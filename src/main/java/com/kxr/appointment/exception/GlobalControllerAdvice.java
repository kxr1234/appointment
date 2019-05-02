package com.kxr.appointment.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {
    /**
     * 
     * Allows exceptions thrown due to annotation-based validation errors on a REST
     * service to be captured here and passed back to a client as an error rest response.
     * 
     */

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public @ResponseBody ApiError handleConstraintViolationException(ConstraintViolationException cve) {

        List<String> messages = new ArrayList<>();
        Iterator<ConstraintViolation<?>> iterator = cve.getConstraintViolations().iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> violation = iterator.next();
            String errorMessage = "Validation error, message = " + violation.getMessage() + ", path = "
                    + violation.getPropertyPath();
            messages.add(errorMessage);
        }
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "VALIDATION FAIL", "Validation error occurred.",
                messages);
    }

    /**
     * 
     * The exception thrown when an annotation-based regular expression validation
     * is detected.
     * 
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public @ResponseBody ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException maenve) {

        List<String> messages = new ArrayList<>();
        List<FieldError> errors = maenve.getBindingResult().getFieldErrors();
        for (FieldError error : errors) {
            String errorMessage = "Validation error, message = " + error.getDefaultMessage() + ", path = "
                    + error.getField();
            messages.add(errorMessage);
        }
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Validation Fail", "Validation error occurred.",
                messages);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ApiError handleException(Exception exception) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "N/A", "Unhandled exception occured.", null);
    }

}
