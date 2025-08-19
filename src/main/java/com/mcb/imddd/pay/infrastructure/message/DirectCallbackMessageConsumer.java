package com.mcb.imddd.pay.infrastructure.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.imddd.pay.domain.service.DirectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DirectCallbackMessageConsumer extends KafkaMessageConsumer<String> {

    @Autowired
    private DirectService directService;

    public DirectCallbackMessageConsumer(ObjectMapper objectMapper, Class<String> messageType) {
        super(objectMapper, messageType);
    }

    @Override
    public void consume(String message) {
        log.info("receive direct callback message: {}", message);
        directService.handleBankCallback(message);
    }

    @Override
    public String getTopic() {
        return "direct-callback";
    }

    @Override
    public String getGroupId() {
        return "payment-direct";
    }
}
