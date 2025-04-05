package com.api.v1.meetimeAPI.service.contact.getContact;

import com.api.v1.meetimeAPI.dto.requests.RequestGetContactsDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseGetContactsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetContact implements GetContactUseCase {

    @Autowired
    private RestTemplate restTemplate;


    private static final String URL = "https://api.hubapi.com/crm/v3/objects/contacts?limit=10";

    @Override
    public ResponseGetContactsDTO execute(RequestGetContactsDTO input) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", input.authorization());
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
            log.info("Contatos obtidos com sucesso : {}", response.getBody());
            return new ResponseGetContactsDTO(response.getBody());
        } catch (Exception e) {
            log.error("Erro ao buscar contatos: {}", e.getMessage());
            return new ResponseGetContactsDTO("Erro ao buscar contatos: " + e.getMessage());
        }
    }
}
