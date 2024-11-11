package com.challenge.captacaoinicial.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptacaoInicialResponse {
    private Integer codigo;
    private String messagem;
}
