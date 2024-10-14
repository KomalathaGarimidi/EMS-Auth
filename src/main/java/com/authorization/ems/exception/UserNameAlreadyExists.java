package com.authorization.ems.exception;

public class UserNameAlreadyExists extends Throwable{
    public UserNameAlreadyExists(String message) {
        super(message);
    }

    public UserNameAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected UserNameAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
