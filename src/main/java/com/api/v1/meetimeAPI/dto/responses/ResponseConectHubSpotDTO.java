package com.api.v1.meetimeAPI.dto.responses;

import lombok.Builder;

@Builder
public record ResponseConectHubSpotDTO(String authorizationUrl) {}
