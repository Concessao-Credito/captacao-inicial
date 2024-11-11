package com.challenge.captacaoinicial.infrastructure.impl;

import com.challenge.captacaoinicial.config.RabbitMQConfig;
import com.challenge.captacaoinicial.domain.request.CaptacaoInicialRequest;
import com.challenge.captacaoinicial.infrastructure.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaptacaoInicialProducer implements Producer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CaptacaoInicialRequest message) {
        log.info("Fim da etapa de captacao inicial");
        rabbitTemplate.convertAndSend(RabbitMQConfig.CAPTACAO_INICIAL_CONCLUIDA, message);
        log.info("Mensagem enviada: " + message);
    }
}
