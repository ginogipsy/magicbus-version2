package com.ginogipsy.magicbus.customexception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Non ho trovato il fritto!")
public class FrittoNotFoundException extends Exception{

    public FrittoNotFoundException(String message) {
        super(message);
    }
}
