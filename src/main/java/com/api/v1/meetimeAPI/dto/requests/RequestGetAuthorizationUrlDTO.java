package com.api.v1.meetimeAPI.dto.requests;

import lombok.Builder;

@Builder
public record RequestGetAuthorizationUrlDTO() {
    public static RequestGetAuthorizationUrlDTO of() {
        return RequestGetAuthorizationUrlDTO.builder().build();
    }
}
