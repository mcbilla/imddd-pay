package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T event);
}
