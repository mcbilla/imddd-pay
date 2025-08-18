package com.mcb.imddd.pay.domain.repository;

import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;

public interface PaymentRepository {
    int create(PaymentAggre paymentAggre);

    PaymentAggre findById(Long id);
}
