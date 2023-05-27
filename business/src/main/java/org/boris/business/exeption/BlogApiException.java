package org.boris.business.exeption;

public class BlogApiException extends RuntimeException {
    public BlogApiException(String message) {
        super(message);
    }
}
