package com.api.v1.meetimeAPI.service;

import org.springframework.stereotype.Service;

@Service
public interface VoidUseCase<I> {
    void execute(I input);
}
