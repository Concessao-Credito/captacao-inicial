package com.challenge.captacaoinicial.controller;

import com.challenge.captacaoinicial.domain.request.CaptacaoInicialRequest;
import com.challenge.captacaoinicial.domain.response.CaptacaoInicialResponse;
import com.challenge.captacaoinicial.service.CaptacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/captacao")
@RequiredArgsConstructor
@Slf4j
public class CaptacaoController {

    private final CaptacaoService captacaoService;

    @PostMapping("/inicial")
    public ResponseEntity<CaptacaoInicialResponse> captacaoInicial(@RequestBody @Valid CaptacaoInicialRequest captacaoInicialRequest) {
        log.info("Iniciando o processo de captacao");
        return captacaoService.save(captacaoInicialRequest);
    }
}
