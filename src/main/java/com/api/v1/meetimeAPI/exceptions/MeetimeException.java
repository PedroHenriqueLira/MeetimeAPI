package com.api.v1.meetimeAPI.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MeetimeException extends RuntimeException {

    private String title;
    private HttpStatus httpStatus;

    public MeetimeException() {
    }

    public MeetimeException(String message) {
        super(message);
    }

    public MeetimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetimeException(String title, String message) {
        super(message);
        this.title = title;
    }

    public MeetimeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public MeetimeException(String title, String message, HttpStatus httpStatus) {
        super(message);
        this.title = title;
        this.httpStatus = httpStatus;
    }

}
