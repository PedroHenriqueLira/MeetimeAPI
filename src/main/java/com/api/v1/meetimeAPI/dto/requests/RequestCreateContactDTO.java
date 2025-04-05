package com.api.v1.meetimeAPI.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Map;

@Builder
public record RequestCreateContactDTO(
        @NotNull(message = "Os dados do contato são obrigatórios")
        Map<String, Object> properties,
        @NotNull(message = "O token de autorização é obrigatório")
        String authorization) {

    public static RequestCreateContactDTO of(Map<String, Object> contactData, String authorization) {
        return RequestCreateContactDTO.builder()
                .properties(contactData)
                .authorization(authorization)
                .build();
    }
}
