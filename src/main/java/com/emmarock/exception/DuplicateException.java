/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emmarock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Adesegun.Adeyemo
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends RuntimeException {

    private static final long serialVersionUID = -5919447122348400126L;

    public DuplicateException() {
    }

    public DuplicateException(String msg) {
        super(msg);
    }

    public DuplicateException(String code, String msg) {
        super(msg);
    }
}
