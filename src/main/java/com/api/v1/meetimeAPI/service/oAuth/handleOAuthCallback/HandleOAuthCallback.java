package com.api.v1.meetimeAPI.service.oAuth.handleOAuthCallback;

import com.api.v1.meetimeAPI.dto.requests.RequestHandleOAuthCallbackDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseHandleOAuthCallbackDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HandleOAuthCallback implements HandleOAuthCallbackUseCase {

    @Value("${hubspot.client-id}")
    private String clientId;

    @Value("${hubspot.redirect-uri}")
    private String redirectUri;

    @Value("${hubspot.client-secret}")
    private String clientSecret;

    @Value("${hubspot.token-url}")
    private String tokenUrl;

    private static final String PARAM_GRANT_TYPE = "grant_type=authorization_code";
    private static final String PARAM_AND_CLIENT_ID = "&client_id=";
    private static final String PARAM_CLIENT_SECRET = "&client_secret=";
    private static final String PARAM_REDIRECT_URI = "&redirect_uri=";
    private static final String PARAM_CODE = "&code=";

    @Override
    public ResponseHandleOAuthCallbackDTO execute(RequestHandleOAuthCallbackDTO input) {
        String formData =
                PARAM_GRANT_TYPE
                        + PARAM_AND_CLIENT_ID
                        + clientId
                        + PARAM_CLIENT_SECRET
                        + clientSecret
                        + PARAM_REDIRECT_URI
                        + redirectUri
                        + PARAM_CODE
                        + input.code();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(formData, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, String.class);
            String responseBody = response.getBody();
            log.info("Token obtido com sucesso do HubSpot");
            return new ResponseHandleOAuthCallbackDTO("Tokens: " + responseBody);
        } catch (Exception e) {
            log.error("Erro ao obter token: {}", e.getMessage());
            return new ResponseHandleOAuthCallbackDTO("Error occurred: " + e.getMessage());
        }
    }
}
