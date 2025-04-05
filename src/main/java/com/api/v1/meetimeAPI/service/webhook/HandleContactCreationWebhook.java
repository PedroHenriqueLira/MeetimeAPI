package com.api.v1.meetimeAPI.service.webhook;

import com.api.v1.meetimeAPI.dto.requests.RequestHandleContactCreationWebhookDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseHandleContactCreationWebhookDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HandleContactCreationWebhook implements HandleContactCreationWebhookUseCase {

    @Override
    public ResponseHandleContactCreationWebhookDTO execute(
            RequestHandleContactCreationWebhookDTO input) {
//        log.info("Webhook recebido: {}", input.webhookData().getFirst());

        return ResponseHandleContactCreationWebhookDTO.builder()
                .message("Webhook processado com sucesso")
                .build();
    }
}
