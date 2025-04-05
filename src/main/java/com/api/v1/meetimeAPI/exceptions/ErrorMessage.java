package com.api.v1.meetimeAPI.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private Integer statusCode;
    private Instant timestamp;
    private String error;
    private String description;
}
