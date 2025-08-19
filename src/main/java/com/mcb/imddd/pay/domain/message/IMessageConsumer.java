package com.mcb.imddd.pay.domain.message;

public interface IMessageConsumer<T> {
    void consume(T message);

    String getTopic();

    String getGroupId();
}
