package com.api.v1.meetimeAPI.service.contact.createContact;

import com.api.v1.meetimeAPI.dto.requests.RequestCreateContactDTO;
import com.api.v1.meetimeAPI.service.UseCase;
import org.springframework.stereotype.Component;

@Component
public interface CreateContactUseCase extends UseCase<RequestCreateContactDTO, Object> {}
