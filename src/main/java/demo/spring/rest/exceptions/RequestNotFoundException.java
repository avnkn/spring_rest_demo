package demo.spring.rest.exceptions;

public class RequestNotFoundException extends RuntimeException {

    public RequestNotFoundException(Integer id) {
        super("Could not find application for contact with id " + id.toString());
    }
}
