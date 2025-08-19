package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;

public interface DomainEventHandler<T extends DomainEvent> {

    boolean canHandle(T event);

    void handle(T event);
}
