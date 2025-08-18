package com.mcb.imddd.pay.infrastructure.util;

import com.mcb.imddd.pay.application.dto.PaymentDTO;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.model.entity.Payment;
import com.mcb.imddd.pay.domain.model.valueobject.Amount;
import com.mcb.imddd.pay.domain.model.valueobject.PaymentStatus;
import com.mcb.imddd.pay.infrastructure.persistence.entity.PaymentPO;

import java.util.UUID;

public class PaymentConverter {

    public static PaymentDTO aggreToDTO(PaymentAggre aggre) {
        return new PaymentDTO(aggre.getPayment().getPayNo());
    }



    public static Payment poToEntity(PaymentPO paymentPO) {
        return Payment.Builder.builder()
                .id(paymentPO.getId())
                .payNo(paymentPO.getPayNo())
                .amount(new Amount(paymentPO.getAmount()))
                .paymentStatus(PaymentStatus.fromCode(paymentPO.getPaymentStatus()))
                .build();
    }

}
