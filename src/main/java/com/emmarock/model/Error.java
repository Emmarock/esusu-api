/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emmarock.model;

/**
 * @author Babajide.Apata
 */
public class Error {

    private String field;
    private String message;

    public Error(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
