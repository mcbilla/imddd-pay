package com.mcb.imddd.pay.domain.base;

public interface DomainEventHandler<T extends DomainEvent> {

    boolean canHandle(T event);

    void handle(T event);
}
