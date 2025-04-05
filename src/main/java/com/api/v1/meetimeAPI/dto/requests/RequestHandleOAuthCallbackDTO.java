package com.api.v1.meetimeAPI.dto.requests;

import lombok.Builder;

@Builder
public record RequestHandleOAuthCallbackDTO(String code) {
    public static RequestHandleOAuthCallbackDTO of(String code) {
        return RequestHandleOAuthCallbackDTO.builder().code(code).build();
    }
}
