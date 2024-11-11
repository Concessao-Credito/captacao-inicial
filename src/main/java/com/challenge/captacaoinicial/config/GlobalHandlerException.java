package com.challenge.captacaoinicial.config;

import com.challenge.captacaoinicial.domain.response.CaptacaoInicialResponse;
import com.challenge.captacaoinicial.exceptions.ProcessamentoMotorCreditoInicialException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>("Dados inválidos: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Dados inválidos: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ProcessamentoMotorCreditoInicialException.class)
    public ResponseEntity<CaptacaoInicialResponse> handleProcessamentoMotorCreditoInicialException(ProcessamentoMotorCreditoInicialException ex) {

        CaptacaoInicialResponse captacaoInicialResponse = CaptacaoInicialResponse
                .builder()
                .codigo(500)
                .messagem("Ocorreu um erro interno com o processamento inicial")
                .build();

        log.info("Um erro ocorreu na comunicação com o Motor de credito inicial: {}", ex.getMessage());

        return new ResponseEntity<>(captacaoInicialResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
