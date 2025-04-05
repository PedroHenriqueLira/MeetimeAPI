package com.api.v1.meetimeAPI.service;


import org.springframework.stereotype.Service;

@Service
public interface UseCase<I, O> {
    O execute(I input);
}
