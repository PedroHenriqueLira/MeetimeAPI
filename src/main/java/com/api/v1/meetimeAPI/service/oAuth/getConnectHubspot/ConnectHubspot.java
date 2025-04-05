package com.api.v1.meetimeAPI.service.oAuth.getConnectHubspot;

import com.api.v1.meetimeAPI.dto.requests.RequestConectHubSpotDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseConectHubSpotDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ConnectHubspot implements ConnectHubspotUseCase {

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

    @Override
    public ResponseConectHubSpotDTO execute(RequestConectHubSpotDTO input) {
        String authUrl =
                authorizationUrl
                        + PARAM_CLIENT_ID
                        + clientId
                        + PARAM_SCOPE
                        + URLEncoder.encode(scope, StandardCharsets.UTF_8)
                        + PARAM_REDIRECT_URI
                        + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);

        log.info("Gerando URL de autorização do HubSpot");
        return ResponseConectHubSpotDTO.builder().authorizationUrl(authUrl).build();
    }
}
