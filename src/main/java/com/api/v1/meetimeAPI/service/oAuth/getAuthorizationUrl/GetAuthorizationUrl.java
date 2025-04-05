package com.api.v1.meetimeAPI.service.oAuth.getAuthorizationUrl;

import com.api.v1.meetimeAPI.dto.requests.RequestGetAuthorizationUrlDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseGetAuthorizationUrlDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAuthorizationUrl implements GetAuthorizationUrlUseCase {

    @Value("${hubspot.client-id}")
    private String clientId;

    @Value("${hubspot.redirect-uri}")
    private String redirectUri;

    @Value("${hubspot.authorization-url}")

    private String authorizationUrl;

    @Value("${hubspot.scope}")
    private String scope;

    private static final String PARAM_CLIENT_ID = "?client_id=";
    private static final String PARAM_SCOPE = "&scope=";
    private static final String PARAM_REDIRECT_URI = "&redirect_uri=";

    public GetAuthorizationUrl(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public ResponseGetAuthorizationUrlDTO execute(RequestGetAuthorizationUrlDTO input) {
        String encodedClientId = URLEncoder.encode(clientId, StandardCharsets.UTF_8);
        String encodedRedirectUri = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        String encodedScope = URLEncoder.encode(scope, StandardCharsets.UTF_8);

        String url =
                authorizationUrl
                        + PARAM_CLIENT_ID
                        + encodedClientId
                        + PARAM_SCOPE
                        + encodedScope
                        + PARAM_REDIRECT_URI
                        + encodedRedirectUri;

        log.info("URL de autorização do HubSpot gerada");
        return new ResponseGetAuthorizationUrlDTO(url);
    }
}
