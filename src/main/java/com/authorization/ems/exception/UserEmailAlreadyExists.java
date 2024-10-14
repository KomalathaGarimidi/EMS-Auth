package com.authorization.ems.exception;

public class UserEmailAlreadyExists extends Throwable{

    public UserEmailAlreadyExists(String message) {
        super(message);
    }

    public UserEmailAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected UserEmailAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
