package com.api.v1.meetimeAPI.service.webhook;


import com.api.v1.meetimeAPI.dto.requests.RequestHandleContactCreationWebhookDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseHandleContactCreationWebhookDTO;
import com.api.v1.meetimeAPI.service.UseCase;

public interface HandleContactCreationWebhookUseCase
        extends UseCase<
        RequestHandleContactCreationWebhookDTO, ResponseHandleContactCreationWebhookDTO> {}
