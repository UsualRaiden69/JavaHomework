package org.example.javawebapp_vadzim.exception;

public class DuplicateResourceException
        extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}