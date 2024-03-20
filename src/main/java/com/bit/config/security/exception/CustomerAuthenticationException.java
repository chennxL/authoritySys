package com.bit.config.security.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomerAuthenticationException extends AuthenticationException {
    public CustomerAuthenticationException(String message){
        super(message);
    }
}
