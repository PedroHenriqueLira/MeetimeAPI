package com.api.v1.meetimeAPI.service.oAuth.handleOAuthCallback;

import com.api.v1.meetimeAPI.dto.requests.RequestHandleOAuthCallbackDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseHandleOAuthCallbackDTO;
import com.api.v1.meetimeAPI.service.UseCase;
import org.springframework.stereotype.Service;

@Service
public interface HandleOAuthCallbackUseCase
        extends UseCase<RequestHandleOAuthCallbackDTO, ResponseHandleOAuthCallbackDTO> {}
