package com.mcb.imddd.pay.domain.factory;

import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.model.valueobject.PaymentStatus;
import com.mcb.imddd.pay.infrastructure.persistence.po.PaymentPO;

import java.util.UUID;

public class PaymentFactory implements IFactory {

    private static class SingletonHolder {
        private static final PaymentFactory INSTANCE = new PaymentFactory();
    }

    public static PaymentFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public PaymentPO createPaymentPO(PaymentAggre aggre) {
        return PaymentPO.Builder.builder()
                .payAccountId(aggre.getPayAccountId())
                .revAccountId(aggre.getRevAccountId())
                .amount(aggre.getPayment().getAmount().getAmount())
                .payNo(UUID.randomUUID().toString())
                .paymentStatus(PaymentStatus.INST.getCode())
                .build();
    }
}
