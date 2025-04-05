package com.api.v1.meetimeAPI.dto.requests;

import com.api.v1.meetimeAPI.dto.WebhookDataDTO;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@Builder
public record RequestHandleContactCreationWebhookDTO(List<WebhookDataDTO> webhookData) {

    public static RequestHandleContactCreationWebhookDTO of(List<WebhookDataDTO> webhookData) {
        return RequestHandleContactCreationWebhookDTO.builder().webhookData(webhookData).build();
    }

    public static RequestHandleContactCreationWebhookDTO of(WebhookDataDTO webhookData) {
        return RequestHandleContactCreationWebhookDTO.builder()
                .webhookData(Collections.singletonList(webhookData))
                .build();
    }
}
