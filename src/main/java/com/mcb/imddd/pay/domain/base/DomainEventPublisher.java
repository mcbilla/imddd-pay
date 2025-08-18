package com.mcb.imddd.pay.domain.base;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T event);
}
