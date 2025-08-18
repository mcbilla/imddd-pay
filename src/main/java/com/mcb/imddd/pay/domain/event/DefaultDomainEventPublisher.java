package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;
import com.mcb.imddd.pay.domain.base.DomainEventHandler;
import com.mcb.imddd.pay.domain.base.DomainEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
public class DefaultDomainEventPublisher implements DomainEventPublisher {
    private final ApplicationContext applicationContext;

    public DefaultDomainEventPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void publish(DomainEvent event) {
        // 获取所有匹配的事件处理器
        String[] beanNames = applicationContext.getBeanNamesForType(
                ResolvableType.forClassWithGenerics(DomainEventHandler.class, event.getClass()));

        for (String beanName : beanNames) {
            DomainEventHandler handler = (DomainEventHandler) applicationContext.getBean(beanName);
            if (handler.canHandle(event)) {
                handler.handle(event);
            }
        }
    }
}
