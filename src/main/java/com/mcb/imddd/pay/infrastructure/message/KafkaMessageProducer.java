package com.mcb.imddd.pay.infrastructure.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.imddd.pay.domain.message.IMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class KafkaMessageProducer implements IMessageProducer<Object> {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String DEFAULT_TOPIC = "default-topic";

    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate,
                                ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public void send(Object message) {
        send(DEFAULT_TOPIC, "", message);
    }

    @Override
    public void send(String topic, Object message) {
        send(topic, "", message);
    }

    @Override
    public void send(String topic, String key, Object message) {
        try {
            String messageJson = objectMapper.writeValueAsString(message);
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, messageJson);

            future.addCallback(
                    result -> log.info("Message sent successfully to topic: {}, partition: {}, offset: {}",
                            topic, result.getRecordMetadata().partition(), result.getRecordMetadata().offset()),
                    ex -> {
                        log.error("Failed to send message to topic: {}", topic, ex);
                        throw new RuntimeException("Failed to send message", ex);
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize message", e);
        }
    }
}
