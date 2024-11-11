package com.challenge.captacaoinicial.service;

import com.challenge.captacaoinicial.domain.request.CaptacaoInicialRequest;
import com.challenge.captacaoinicial.domain.response.CaptacaoInicialResponse;
import org.springframework.http.ResponseEntity;

public interface CaptacaoService {
    ResponseEntity<CaptacaoInicialResponse> save(CaptacaoInicialRequest captacaoInicialRequest);
}
