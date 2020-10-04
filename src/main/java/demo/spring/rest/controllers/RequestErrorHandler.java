package demo.spring.rest.controllers;

import demo.spring.rest.exceptions.RequestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class RequestErrorHandler {
    private static final String ERROR_FORMAT = "{\"error\" : \"%s\"}";
    private static final String ERROR_VALUE_ID = "Incorrect value Id";

    @ResponseBody
    @ExceptionHandler(RequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String contactNotFoundHandler(RequestNotFoundException ex) {
        return String.format(ERROR_FORMAT, ex.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String contactErrorValueIdHandler() {
        return String.format(ERROR_FORMAT, ERROR_VALUE_ID);
    }
}
