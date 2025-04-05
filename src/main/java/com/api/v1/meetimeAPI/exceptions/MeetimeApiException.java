package com.api.v1.meetimeAPI.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MeetimeApiException extends RuntimeException {

    private String title;
    private HttpStatus httpStatus;

    public MeetimeApiException() {
    }

    public MeetimeApiException(String message) {
        super(message);
    }

    public MeetimeApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetimeApiException(String title, String message) {
        super(message);
        this.title = title;
    }

    public MeetimeApiException(String title, String message, HttpStatus httpStatus) {
        super(message);
        this.title = title;
        this.httpStatus = httpStatus;
    }


}