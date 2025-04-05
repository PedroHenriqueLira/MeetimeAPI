package com.api.v1.meetimeAPI.service.contact.getContact;

import com.api.v1.meetimeAPI.dto.requests.RequestGetContactsDTO;
import com.api.v1.meetimeAPI.dto.responses.ResponseGetContactsDTO;
import com.api.v1.meetimeAPI.service.UseCase;
import org.springframework.stereotype.Component;

@Component
public interface GetContactUseCase extends UseCase<RequestGetContactsDTO, ResponseGetContactsDTO> {}
