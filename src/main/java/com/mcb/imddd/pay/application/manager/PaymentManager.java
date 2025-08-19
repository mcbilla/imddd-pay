package com.mcb.imddd.pay.application.manager;

import com.mcb.imddd.pay.application.command.TransferCommand;
import com.mcb.imddd.pay.application.dto.PaymentDTO;
import com.mcb.imddd.pay.domain.event.DomainEventPublisher;
import com.mcb.imddd.pay.domain.event.PaymentCreateEvent;
import com.mcb.imddd.pay.domain.model.aggregate.AccountAggre;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.service.AccountService;
import com.mcb.imddd.pay.domain.service.PaymentService;
import com.mcb.imddd.pay.infrastructure.util.PaymentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentManager {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private DomainEventPublisher<PaymentCreateEvent> domainEventPublisher;

    @Transactional(rollbackFor = Exception.class)
    public PaymentDTO transfer(TransferCommand transferCommand) {
        AccountAggre payAccountAggre = accountService.findByAccountNo(transferCommand.getPayAccountNo());
        AccountAggre revAccountAggre = accountService.findByAccountNo(transferCommand.getRevAccountNo());

        PaymentAggre paymentAggre = new PaymentAggre(payAccountAggre.getId(), revAccountAggre.getId(), transferCommand.getAmount());
        paymentService.save(paymentAggre);

        PaymentCreateEvent paymentDomainEvent = new PaymentCreateEvent(paymentAggre.getId());
        domainEventPublisher.publish(paymentDomainEvent);

        return PaymentConverter.aggreToDTO(paymentAggre);
    }
}
