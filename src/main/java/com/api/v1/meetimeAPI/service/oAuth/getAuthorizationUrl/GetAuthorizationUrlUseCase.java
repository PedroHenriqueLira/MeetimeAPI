package com.api.v1.meetimeAPI.service.oAuth.getAuthorizationUrl;


import com.api.v1.meetimeAPI.dto.requests.RequestGetAuthorizationUrlDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseGetAuthorizationUrlDTO;
import com.api.v1.meetimeAPI.service.UseCase;

public interface GetAuthorizationUrlUseCase
        extends UseCase<RequestGetAuthorizationUrlDTO, ResponseGetAuthorizationUrlDTO> {}
