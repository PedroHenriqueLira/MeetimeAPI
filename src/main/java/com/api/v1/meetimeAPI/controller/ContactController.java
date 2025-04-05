package com.api.v1.meetimeAPI.controller;

import com.api.v1.meetimeAPI.dto.requests.RequestCreateContactDTO;
import com.api.v1.meetimeAPI.dto.requests.RequestGetContactsDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseCreateContactDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseGetContactsDTO;
import com.api.v1.meetimeAPI.service.contact.createContact.CreateContact;
import com.api.v1.meetimeAPI.service.contact.getContact.GetContact;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ContactController {
    private final CreateContact createContactUseCase;
    private final GetContact getContactsUseCase;

    @PostMapping("/create-contact")
    public ResponseEntity<ResponseCreateContactDTO> createContact(
            @RequestHeader("Authorization") String authorizationHeader,
            @Valid @RequestBody Map<String, Object> contactData) {

        RequestCreateContactDTO requestDTO =
                RequestCreateContactDTO.of(contactData, authorizationHeader);

        return ResponseEntity.status(HttpStatus.CREATED).body(createContactUseCase.execute(requestDTO));
    }

    @GetMapping("/get-contacts")
    public ResponseEntity<ResponseGetContactsDTO> getContacts(
            @RequestHeader("Authorization") String authorizationHeader) {

        RequestGetContactsDTO requestDTO = RequestGetContactsDTO.of(authorizationHeader);
        return ResponseEntity.ok(getContactsUseCase.execute(requestDTO));
    }
}
