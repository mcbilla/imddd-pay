package com.mcb.imddd.pay.infrastructure.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.imddd.pay.domain.message.IMessageConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public abstract class KafkaMessageConsumer<T> implements IMessageConsumer<T> {
    protected final ObjectMapper objectMapper;

    protected final Class<T> messageType;

    public KafkaMessageConsumer(ObjectMapper objectMapper, Class<T> messageType) {
        this.objectMapper = objectMapper;
        this.messageType = messageType;
    }

    @KafkaListener(topics = "#{__listener.getTopic()}", groupId = "#{__listener.getGroupId()}")
    public void listen(String messageJson) {
        try {
            T message = objectMapper.readValue(messageJson, messageType);
            consume(message);
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize message: {}", messageJson, e);
            throw new RuntimeException("Failed to deserialize message", e);
        }
    }
}
