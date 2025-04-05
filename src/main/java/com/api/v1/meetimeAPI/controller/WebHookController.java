package com.api.v1.meetimeAPI.controller;

import com.api.v1.meetimeAPI.dto.WebhookDataDTO;
import com.api.v1.meetimeAPI.dto.requests.RequestHandleContactCreationWebhookDTO;
import com.api.v1.meetimeAPI.service.webhook.HandleContactCreationWebhookUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WebHookController {

    private final HandleContactCreationWebhookUseCase handleContactCreationWebhookUseCase;

    @PostMapping("/webhook/contact-creation")
    public ResponseEntity<String> handleContactCreationWebhook(
            @RequestBody List<WebhookDataDTO> webhookData) {
        RequestHandleContactCreationWebhookDTO requestDTO =
                RequestHandleContactCreationWebhookDTO.of(webhookData);

        return ResponseEntity.ok(handleContactCreationWebhookUseCase.execute(requestDTO).message());
    }


    @PostMapping("/webhook/contact-creation-local")
    public ResponseEntity<String> handleContactCreationWebhook(
            @RequestBody WebhookDataDTO webhookData) {
        RequestHandleContactCreationWebhookDTO requestDTO =
                RequestHandleContactCreationWebhookDTO.of(webhookData);

        return ResponseEntity.ok(handleContactCreationWebhookUseCase.execute(requestDTO).message());
    }
}