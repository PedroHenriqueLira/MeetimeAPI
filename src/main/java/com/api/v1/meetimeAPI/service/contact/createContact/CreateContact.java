package com.api.v1.meetimeAPI.service.contact.createContact;


import com.api.v1.meetimeAPI.dto.requests.RequestCreateContactDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseCreateContactDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateContact implements CreateContactUseCase {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseCreateContactDTO execute(RequestCreateContactDTO input) {
        String url = "https://api.hubapi.com/crm/v3/objects/contacts";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", input.authorization());
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(input.properties(), headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            log.info("Contato criado: {}", response.getBody());
            return new ResponseCreateContactDTO(response.getBody());

        } catch (Exception e) {
            log.error("Erro ao criar contato: {}", e.getMessage());
            return new ResponseCreateContactDTO("Erro ao criar contato: " + e.getMessage());
        }
    }
}
