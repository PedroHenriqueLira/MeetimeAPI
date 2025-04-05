package com.api.v1.meetimeAPI.exceptions;

import com.api.v1.meetimeAPI.dto.responses.ResponsePadraoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourcesExceptionHandler {


    @ExceptionHandler(MeetimeApiException.class)
    public ResponseEntity<ErrorMessage> getMeetimeApiException(MeetimeApiException e, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage = new ErrorMessage(e.getHttpStatus().value(), Instant.now(), e.getTitle(), e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(errorMessage);
    }

    @ExceptionHandler(MeetimeException.class)
    public ResponseEntity<ResponsePadraoDTO> getMeetimeException(MeetimeException e, HttpServletRequest httpServletRequest) {
        ResponsePadraoDTO erro = ResponsePadraoDTO.falha(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(erro);
    }
}

