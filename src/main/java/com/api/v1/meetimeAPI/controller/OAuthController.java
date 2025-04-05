package com.api.v1.meetimeAPI.controller;

import com.api.v1.meetimeAPI.dto.requests.RequestConectHubSpotDTO;
import com.api.v1.meetimeAPI.dto.requests.RequestGetAuthorizationUrlDTO;
import com.api.v1.meetimeAPI.dto.requests.RequestHandleOAuthCallbackDTO;
import com.api.v1.meetimeAPI.service.oAuth.getAuthorizationUrl.GetAuthorizationUrlUseCase;
import com.api.v1.meetimeAPI.service.oAuth.getConnectHubspot.ConnectHubspotUseCase;
import com.api.v1.meetimeAPI.service.oAuth.handleOAuthCallback.HandleOAuthCallbackUseCase;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class OAuthController {
    @Autowired(required = false)
    private ConnectHubspotUseCase connectHubspotUseCase;
    @Autowired
    private GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;
    @Autowired
    private HandleOAuthCallbackUseCase handleOAuthCallbackUseCase;

    @GetMapping("/connect-hubspot")
    public void getConnectHubspot(HttpServletResponse response) throws IOException {
        RequestConectHubSpotDTO requestDTO = RequestConectHubSpotDTO.of();
        String authUrl = connectHubspotUseCase.execute(requestDTO).authorizationUrl();
        response.sendRedirect(authUrl);
    }

    @GetMapping("/oauth/authorization-url")
    public String getAuthorizationUrl() {
        RequestGetAuthorizationUrlDTO requestDTO = RequestGetAuthorizationUrlDTO.of();
        return getAuthorizationUrlUseCase.execute(requestDTO).authorizationUrl();
    }

    @GetMapping("/oauth/callback")
    public String handleOAuthCallback(@RequestParam("code") String code) {
        RequestHandleOAuthCallbackDTO requestDTO = RequestHandleOAuthCallbackDTO.of(code);
        return handleOAuthCallbackUseCase.execute(requestDTO).responseBody();
    }
}