package com.api.v1.meetimeAPI.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RequestGetContactsDTO(
        @NotNull(message = "O token de autorização é obrigatório")
        String authorization) {

    public static RequestGetContactsDTO of(String authorization) {
        return RequestGetContactsDTO.builder().authorization(authorization).build();
    }
}
