package com.nkosi.Enrolment_Manager.exceptions;

public class DuplicationFoundException extends RuntimeException {
    private static final long serialVersionUID = 34L;

    public DuplicationFoundException(String message) {
        super(message);
    }
}
