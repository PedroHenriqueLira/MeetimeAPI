package com.api.v1.meetimeAPI.service.oAuth.getConnectHubspot;


import com.api.v1.meetimeAPI.dto.requests.RequestConectHubSpotDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseConectHubSpotDTO;
import com.api.v1.meetimeAPI.service.UseCase;
import org.springframework.stereotype.Service;

@Service
public interface ConnectHubspotUseCase
        extends UseCase<RequestConectHubSpotDTO, ResponseConectHubSpotDTO> {
}
