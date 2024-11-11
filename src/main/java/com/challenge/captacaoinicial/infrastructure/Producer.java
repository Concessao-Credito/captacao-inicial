package com.challenge.captacaoinicial.infrastructure;

import com.challenge.captacaoinicial.domain.request.CaptacaoInicialRequest;

public interface Producer {
    void sendMessage(CaptacaoInicialRequest request);
}
