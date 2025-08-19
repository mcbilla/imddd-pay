package com.mcb.imddd.pay.domain.message;

public interface IMessageProducer<T> {

    void send(T message);

    void send(String topic, T message);

    void send(String topic, String key, T message);
}
