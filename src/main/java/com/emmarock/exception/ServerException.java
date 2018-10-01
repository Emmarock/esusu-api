package com.emmarock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Babajide.Apata on 3/3/2017.
 */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ServerException extends RuntimeException{
    private static final long serialVersionUID = -5919447122348400126L;

    public ServerException() {
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }
}
