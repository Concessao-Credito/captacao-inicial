package com.challenge.captacaoinicial.service.impl;


import com.challenge.captacaoinicial.domain.request.CaptacaoInicialRequest;
import com.challenge.captacaoinicial.domain.response.CaptacaoInicialResponse;
import com.challenge.captacaoinicial.exceptions.ProcessamentoMotorCreditoInicialException;
import com.challenge.captacaoinicial.infrastructure.Producer;
import com.challenge.captacaoinicial.service.CaptacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaptacaoServiceImpl implements CaptacaoService {

    private final Producer producer;

    @Override
    public ResponseEntity<CaptacaoInicialResponse> save(CaptacaoInicialRequest captacaoInicialRequest) {
        try {
            producer.sendMessage(captacaoInicialRequest);
            return new ResponseEntity<>(CaptacaoInicialResponse
                    .builder()
                    .codigo(200)
                    .messagem("Proposta enviada com sucesso!!")
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ProcessamentoMotorCreditoInicialException();
        }
    }
}
