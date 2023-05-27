package org.boris.business.exeption;

import lombok.Getter;

@Getter
public class EntityNameExistsException extends RuntimeException{
    public EntityNameExistsException(String message) {
        super(message);
    }
}
