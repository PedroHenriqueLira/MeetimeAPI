package com.api.v1.meetimeAPI.dto.requests;

import lombok.Builder;

@Builder
public record RequestConectHubSpotDTO() {
    public static RequestConectHubSpotDTO of() {
        return RequestConectHubSpotDTO.builder().build();
    }
}
