package com.challenge.captacaoinicial.domain.request;

import com.challenge.captacaoinicial.validation.CPF;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CaptacaoInicialRequest {
    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo CPF não pode ser nulo")
    @CPF
    private String cpf;

    @NotBlank(message = "O Campo email não pode ser nulo")
    private String email;
}
