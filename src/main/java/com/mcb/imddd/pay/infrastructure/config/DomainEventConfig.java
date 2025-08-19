package com.mcb.imddd.pay.infrastructure.config;

import com.mcb.imddd.pay.domain.event.DomainEventPublisher;
import com.mcb.imddd.pay.domain.event.DefaultDomainEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainEventConfig {

    @Bean
    public DomainEventPublisher domainEventPublisher(ApplicationContext applicationContext) {
        return new DefaultDomainEventPublisher(applicationContext);
    }
}